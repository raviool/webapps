package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.document.Document;
import java.util.List;

@Service("documentSearchHibernateService")
public class DocumentSearchHibernateService {

    public DocumentSearchHibernateService() {};

	@SuppressWarnings("unchecked")
	public List<Document> findDocuments(String query) {
		List <Document> documents = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createSQLQuery(query);
            documents = q.list();
        } finally {
            session.close();
        }
        return documents;
	}
}
