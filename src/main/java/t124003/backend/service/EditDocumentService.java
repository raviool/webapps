package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import t124003.backend.model.document.DocAttribute;
import t124003.backend.model.document.Document;
import t124003.backend.service.sessionmanagement.CustomUserDetails;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Raviool on 27.05.2015.
 */
@Service("editDocumentService")
public class EditDocumentService {

    public void editDocumentFromRequest(HttpServletRequest req, CustomUserDetails principal) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Document old = new Document();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM Document WHERE document=:doc");
            q.setInteger("doc", Integer.parseInt(req.getParameter("id")));
            old = (Document) q.uniqueResult();
        } finally {
            session.close();
        }

        session = HibernateUtil.getSessionFactory().openSession();
        Document document = new Document();
        document.setDocument(Integer.parseInt(req.getParameter("id")));
        document.setName(req.getParameter("name"));
        document.setDescription(req.getParameter("description"));
        document.setDocStatusTypeFk(Integer.parseInt(req.getParameter("status")));
        document.setCreated(old.getCreated());
        document.setCreatedBy(old.getCreatedBy());

        try {
            session.beginTransaction();
            session.update(document);
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }

        DocAttributeHibernateService docAttributeHibernateService = new DocAttributeHibernateService();
        List<DocAttribute> docAttributes = docAttributeHibernateService.findDocumentAttributes(document.getDocument());
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
            updateAttribute(da);
        }

        UpdateDateService updateDateService = new UpdateDateService();
        updateDateService.updateDocEditDate(principal.getUsername(), document.getDocument());
        DocCatalogHibernateService docCatalogHibernateService = new DocCatalogHibernateService();
        updateDateService.updateCatalogEditDate(principal.getUsername(), docCatalogHibernateService.findDocumentCatalog(document.getDocument()));
        if (!old.getDocStatusTypeFk().equals(document.getDocStatusTypeFk())) {
            StatusUpdateService statusUpdateService = new StatusUpdateService();
            statusUpdateService.updateDocumentStatusHistory(document.getDocument(), document.getDocStatusTypeFk(), principal.getUsername());
        }
    }

    private void updateAttribute(DocAttribute attribute) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(attribute);
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
