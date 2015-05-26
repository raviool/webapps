package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import t124003.backend.model.document.DocStatusType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raviool on 26.05.2015.
 */
@Service("statusService")
public class StatusHibernateService {

    public List<DocStatusType> getStatuses() {
        List<DocStatusType> statuses = new ArrayList<DocStatusType>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocStatusType");
            statuses = q.list();
        } finally {
            session.close();
        }
        return statuses;
    }

}
