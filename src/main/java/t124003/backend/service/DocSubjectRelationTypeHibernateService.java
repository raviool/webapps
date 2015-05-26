package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.document.DocSubjectRelationType;

import java.util.List;

/**
 * @author Dan
 */
@Service("docSubjectRelationTypeHibernateService")
public class DocSubjectRelationTypeHibernateService {

    public DocSubjectRelationTypeHibernateService() {};

    @SuppressWarnings("unchecked")
	public List<DocSubjectRelationType> findDocSubjectRelationTypes() {
        List <DocSubjectRelationType> docSubjectRelationTypes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocSubjectRelationType");
            docSubjectRelationTypes = q.list();
        } finally {
            session.close();
        }
        return docSubjectRelationTypes;
    }
}
