package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.db.DBConnection;
import t124003.backend.model.document.DocCatalog;
import t124003.backend.model.document.Document;

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
            Query q = session.createQuery("FROM DocCatalog WHERE level=:level");
            q.setInteger("level", level);
            docCatalogs = q.list();
        } finally {
            session.close();
        }
        return docCatalogs;
    }
    
    // Non-hibernate method in an Hibernate service.
	public List<Document> findDocumentsByCatalogId(int catalog_id) {
        Statement s = null;
		ResultSet rs = null;
		Document document;
		List<Document> documents = new ArrayList<Document>();
		String query = "SELECT document, name FROM document INNER JOIN document_doc_catalog ON document.document=document_doc_catalog.document_fk WHERE doc_catalog_fk=" + catalog_id + ";";
		
		try {
			s = DBConnection.getConnection().createStatement();
			rs = s.executeQuery(query);
			while (rs.next()) {
				document = new Document();
				document.setDocument(rs.getInt("document"));
				document.setName(rs.getString("name"));
				documents.add(document);
			}
            s.close();
		} catch (SQLException e) {
			// Log.
		}
		
        return documents;
    }

    // Non-hibernate method in an Hibernate service.
    public List<Document> findAllDocuments() {
        Statement s = null;
        ResultSet rs = null;
        Document document;
        List<Document> documents = new ArrayList<Document>();
        String query = "SELECT document, name FROM document INNER JOIN document_doc_catalog ON document.document=document_doc_catalog.document_fk;";

        try {
            s = DBConnection.getConnection().createStatement();
            rs = s.executeQuery(query);
            while (rs.next()) {
                document = new Document();
                document.setDocument(rs.getInt("document"));
                document.setName(rs.getString("name"));
                documents.add(document);
            }
            s.close();
        } catch (SQLException e) {
            // Log.
        }

        return documents;
    }
}
