package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.document.DocStatusType;

import java.util.List;

/**
 * @author Dan
 */
@Service("docStatusTypeHibernateService")
public class DocStatusTypeHibernateService {

    public DocStatusTypeHibernateService() {};

    @SuppressWarnings("unchecked")
	public List<DocStatusType> findDocStatusTypes() {
        List <DocStatusType> docStatusTypes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocStatusType");
            docStatusTypes = q.list();
        } finally {
            session.close();
        }
        return docStatusTypes;
    }
}
