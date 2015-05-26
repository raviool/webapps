package t124003.backend.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.db.DBConnection;
import t124003.backend.model.document.DocCatalog;
import t124003.backend.model.document.Document;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raviool on 22.05.2015.
 */
@Service("DocCatalogHibernateService")
public class DocCatalogHibernateService {
	static Logger l = Logger.getLogger(DocCatalogHibernateService.class.getName());

    UpdateDateService updateDateService = new UpdateDateService();

    @SuppressWarnings("unchecked")
    public List<DocCatalog> findAllCatalogs() {
        List<DocCatalog> docCatalogs = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocCatalog");
            docCatalogs = q.list();
        } finally {
            session.close();
        }
        return docCatalogs;
    }

    @SuppressWarnings("unchecked")
    public List<DocCatalog> findNthLevelCatalogs(int level) {
        List<DocCatalog> docCatalogs = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocCatalog WHERE level=:level ORDER BY docCatalog");
            q.setInteger("level", level);
            docCatalogs = q.list();
        } finally {
            session.close();
        }
        return docCatalogs;
    }

    public DocCatalog findCatalog(int id) {
        DocCatalog catalog = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocCatalog WHERE docCatalog=:catalog");
            q.setInteger("catalog", id);
            catalog = (DocCatalog) q.uniqueResult();
        } finally {
            session.close();
        }
        return catalog;
    }

    // Non-hibernate method in an Hibernate service.
    public List<Document> findDocumentsByCatalogId(int catalog_id) throws SQLException {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        Document document;
        List<Document> documents = new ArrayList<Document>();
        String query = "SELECT document, name FROM document INNER JOIN document_doc_catalog ON document.document=document_doc_catalog.document_fk WHERE doc_catalog_fk=" + catalog_id + ";";

        try {
            c = DBConnection.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(query);
            while (rs.next()) {
                document = new Document();
                document.setDocument(rs.getInt("document"));
                document.setName(rs.getString("name"));
                documents.add(document);
            }
        } catch (SQLException e) {
        	l.error((new StringBuilder()).append("DocCatalogHibernateService.findDocumentsByCatalogId(): ").append(e.getMessage()));
        } finally {
            DBConnection.close(c);
        }

        return documents;
    }

    public List<Document> findAllDocuments() throws SQLException {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        Document document;
        List<Document> documents = new ArrayList<Document>();
        String query = "SELECT document, name FROM document INNER JOIN document_doc_catalog ON document.document=document_doc_catalog.document_fk ORDER BY document.document;";
        try {
            c = DBConnection.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(query);
            while (rs.next()) {
                document = new Document();
                document.setDocument(rs.getInt("document"));
                document.setName(rs.getString("name"));
                documents.add(document);
            }
            s.close();
        } catch (SQLException e) {
        	l.error((new StringBuilder()).append("DocCatalogHibernateService.findAllDocuments(): ").append(e.getMessage()));
        } finally {
            DBConnection.close(c);
        }

        return documents;
    }

    public Integer findDocumentCatalog(int documentId) {
        System.out.println("running...");
        Integer catalog = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            System.out.println("beginning...");
            Query q = session.createQuery("SELECT docCatalogFk FROM DocumentDocCatalog WHERE documentFk=:document");
            System.out.println("query...");
            q.setInteger("document", documentId);
            System.out.println("going...");
            catalog = (Integer) q.uniqueResult();
            System.out.println("catalog:" + catalog);
        } finally {
            session.close();
        }
        return catalog;
    }

    public void moveDocToCatalog(int document, int catalog, String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer oldCatalog = null;
        try {
            session.beginTransaction();
            Query q = session.createQuery("SELECT docCatalogFk FROM DocumentDocCatalog WHERE documentFk=:document");
            q.setInteger("document", document);
            oldCatalog = (Integer) q.uniqueResult();
            q = session.createQuery("UPDATE DocumentDocCatalog SET docCatalogFk=:catalog, catalogTime=current_timestamp WHERE documentFk=:document");
            q.setInteger("catalog", catalog);
            q.setInteger("document", document);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
        System.out.println(username + " " + document);
        updateDateService.updateDocEditDate(username, document);
        System.out.println(username + " " + catalog);
        updateDateService.updateCatalogEditDate(username, catalog);
        System.out.println(username + " " + oldCatalog);
        updateDateService.updateCatalogEditDate(username, oldCatalog);
    }
}
