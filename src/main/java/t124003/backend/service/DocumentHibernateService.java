package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.document.DocType;
import t124003.backend.model.document.Document;

/**
 * Created by Raviool on 21.05.2015.
 */
@Service("documentService")
public class DocumentHibernateService {

    public DocumentHibernateService() {};

    public Document findById(int id) {
        Document document = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try  {
            session.beginTransaction();
            Query q = session.createQuery("FROM Document as d WHERE d.document=:id");
            q.setInteger("id", id);
            document = (Document) q.uniqueResult();
        } finally {
            session.close();
        }
        return document;
    }

    public DocType findDocType(Document document) {
        DocType docType = null;
        int id = document.getDocument();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocType WHERE docType=(SELECT docTypeFk FROM DocumentDocType WHERE documentFk=:id)");
            q.setInteger("id", id);
            docType = (DocType) q.uniqueResult();
        } finally {
            session.close();
        }
        return docType;
    }

    public DocType findDocType(int type) {
        DocType docType = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocType WHERE docType=:type");
            q.setInteger("type", type);
            docType = (DocType) q.uniqueResult();
        } finally {
            session.close();
        }
        return docType;
    }
}
