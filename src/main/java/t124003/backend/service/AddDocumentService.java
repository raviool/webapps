package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import t124003.backend.model.document.*;
import t124003.backend.service.sessionmanagement.CustomUserDetails;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * Created by Raviool on 26.05.2015.
 */

@Service("addDocumentService")
public class AddDocumentService {

    public void addDocumentFromRequest(HttpServletRequest req, CustomUserDetails principal) {
        //Preparing the document
        System.out.println("adding...");
        Document document = new Document();
        document.setName(req.getParameter("name"));
        System.out.println(document.getName());
        document.setDescription(req.getParameter("description"));
        System.out.println(document.getDescription());
        document.setDocStatusTypeFk(Integer.parseInt(req.getParameter("status")));
        int docId = addDocument(document, principal);

        //Getting newly added document ID and using it for various things.
        updateCatalog(docId, Integer.parseInt(req.getParameter("catalog")));
        addDocType(docId, Integer.parseInt(req.getParameter("type")));
        List<DocAttribute> docAttributes = getTypeSpecificAttributes(docId, Integer.parseInt(req.getParameter("type")));

        for (DocAttribute da: docAttributes) {
            if (da.getDataType() == 1) {
                String value = req.getParameter(da.getDocAttributeTypeFk() + "");
                System.out.println(da.getTypeName() + ": " + value);
                da.setValueText(value);
            }
            if (da.getDataType() == 2) {
                int value = Integer.parseInt(req.getParameter(da.getDocAttributeTypeFk() + ""));
                System.out.println(da.getTypeName() + ": " + value);
                da.setValueNumber(value);
            }
            if (da.getDataType() == 3) {
                System.out.println("DATE: " + req.getParameter(da.getDocAttributeTypeFk() + ""));
                String param = req.getParameter(da.getDocAttributeTypeFk() + "");
                Date value = Date.valueOf(param);
                System.out.println(value);
                da.setValueDate(value);
            }
            if (da.getDataType() == 4) {
                int value = Integer.parseInt(req.getParameter(da.getDocAttributeTypeFk() + ""));
                System.out.println(da.getTypeName() + ": " + value);
                da.setAtrTypeSelectionValueFk(value);
            }
            insertAttribute(da);
        }

        //Update status history and dates
        UpdateDateService updateDateService = new UpdateDateService();
        StatusUpdateService statusUpdateService = new StatusUpdateService();
        updateDateService.updateCatalogEditDate(principal.getUsername(), Integer.parseInt(req.getParameter("catalog")));
        statusUpdateService.updateDocumentStatusHistory(docId, Integer.parseInt(req.getParameter("status")), principal.getUsername());



    }

    public int addDocument(Document document, CustomUserDetails principal) {
        int docId = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(document);
            docId = document.getDocument();
            System.out.println(docId);
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
        UpdateDateService updateDateService = new UpdateDateService();
        updateDateService.updateDocCreateDate(principal.getUsername(), docId);
        return docId;
    }

    public void updateCatalog(int docId, int catalog) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        DocumentDocCatalog documentDocCatalog = new DocumentDocCatalog();
        documentDocCatalog.setCatalogTime(new Timestamp(new java.util.Date().getTime()));
        documentDocCatalog.setDocumentFk(docId);
        documentDocCatalog.setDocCatalogFk(catalog);
        try {
            session.beginTransaction();
            session.save(documentDocCatalog);
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void insertAttribute(DocAttribute attribute) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(attribute);
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void addDocType(int docId, int docType) {
        DocumentDocType documentDocType = new DocumentDocType();
        documentDocType.setDocumentFk(docId);
        documentDocType.setDocTypeFk(docType);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(documentDocType);
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public List<DocAttribute> getTypeSpecificAttributes(int docId, int docType) {
        List<DocAttribute> docAttributes = new ArrayList<DocAttribute>();
        DocAttributeHibernateService docAttributeHibernateService = new DocAttributeHibernateService();
        List<DocAttributeType> docAttributeTypes = docAttributeHibernateService.findDocumentTypeAttributes(docType);
        int i = 1;
        for (DocAttributeType dat: docAttributeTypes) {
            System.out.println(dat.getDocAttributeType());
            DocAttribute da = new DocAttribute();
            da.setDocumentFk(docId);
            da.setDocAttributeTypeFk(dat.getDocAttributeType());
            da.setDocumentFk(docId);
            da.setTypeName(dat.getTypeName());
            da.setDataType(dat.getDataTypeFk());
            da.setOrderby(i++);
            da.setRequired(docAttributeHibernateService.required(da.getDocAttributeTypeFk(), docType));
            System.out.println(da.getRequired());
            docAttributes.add(da);
        }
        return docAttributes;
    }

}
