package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.document.DocType;

import java.util.List;

/**
 * @author Dan
 */
@Service("docTypeHibernateService")
public class DocTypeHibernateService {

    public DocTypeHibernateService() {};

    @SuppressWarnings("unchecked")
	public List<DocType> findDocTypes() {
        List <DocType> docTypes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocType");
            docTypes = q.list();
        } finally {
            session.close();
        }
        return docTypes;
    }

    public List<DocType> findUsableDocTypes() {
        List <DocType> docTypes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocType WHERE level=2");
            docTypes = q.list();
        } finally {
            session.close();
        }
        return docTypes;
    }
}
