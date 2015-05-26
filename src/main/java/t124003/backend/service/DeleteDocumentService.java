package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

/**
 * Created by Raviool on 26.05.2015.
 */
@Service("deleteDocumentService")
public class DeleteDocumentService {

    public void deleteDocument(int docId, String username) {
        System.out.println("Document:"  + docId);
        System.out.println("Username:" + username);
        DocCatalogHibernateService docCatalogHibernateService = new DocCatalogHibernateService();
        Integer catalog = new Integer(docCatalogHibernateService.findDocumentCatalog(docId));
        deleteFromDocument(docId);
        deleteFromDocAttribute(docId);
        deleteFromDocumentDocCatalog(docId);
        deleteFromDocumentDocType(docId);
        deleteFromDocStatus(docId);
        UpdateDateService updateDateService = new UpdateDateService();
        updateDateService.updateCatalogEditDate(username, catalog);
    }

    public void deleteFromDocument(int docId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("DELETE Document WHERE document=:doc");
            q.setInteger("doc", docId);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteFromDocAttribute(int docId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("DELETE DocAttribute WHERE documentFk=:doc");
            q.setInteger("doc", docId);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteFromDocumentDocCatalog(int docId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("DELETE DocumentDocCatalog WHERE documentFk=:doc");
            q.setInteger("doc", docId);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteFromDocumentDocType(int docId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("DELETE DocumentDocType WHERE documentFk=:doc");
            q.setInteger("doc", docId);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteFromDocStatus(int docId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("DELETE DocStatus WHERE documentFk=:doc");
            q.setInteger("doc", docId);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
