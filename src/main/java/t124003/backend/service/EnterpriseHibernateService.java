package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.subject.Enterprise;
import java.util.List;

/**
 * @author Dan
 */
@Service("enterpriseHibernateService")
public class EnterpriseHibernateService {

    public EnterpriseHibernateService() {};

	@SuppressWarnings("unchecked")
	public List<Enterprise> findEnterprisesByName(String name) {
		List <Enterprise> enterprises = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM Enterprise as e WHERE UPPER(e.name) LIKE UPPER(:name)");
            q.setString("name","%" + name + "%");
            enterprises = q.list();
        } finally {
            session.close();
        }
        return enterprises;
	}

	@SuppressWarnings("unchecked")
	public List<Enterprise> findAllEnterprises() {
		List <Enterprise> enterprises = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM Enterprise");
            enterprises = q.list();
        } finally {
            session.close();
        }
        return enterprises;
	}
}
