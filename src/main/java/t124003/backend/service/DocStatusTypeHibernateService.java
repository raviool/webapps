package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.document.DocStatusType;

import java.util.List;

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
        DocStatusType empty = new DocStatusType();
        empty.setTypeName("");
        docStatusTypes.add(empty);
        return docStatusTypes;
    }
}
