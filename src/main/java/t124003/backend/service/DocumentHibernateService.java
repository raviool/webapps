package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import t124003.backend.model.DocAttribute;
import t124003.backend.model.DocAttributeType;
import t124003.backend.model.Document;

import java.util.List;

/**
 * Created by Raviool on 21.05.2015.
 */
@Service("documentService")
public class DocumentHibernateService {

    public DocumentHibernateService() {};

    private Document document;

    public Document findById(int id) {
        document = null;
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




}
