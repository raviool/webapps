package t124003.backend.service;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.document.DocSubject;

/**
 * @author Dan
 */
@Service("docSubjectHibernateService")
public class DocSubjectHibernateService {
	static Logger l = Logger.getLogger(DocSubjectHibernateService.class.getName());
	
	public DocSubjectHibernateService() {};

    public void insertDocSubject(DocSubject docSubject) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try  {
            session.beginTransaction();
            session.save(docSubject);
        } finally {
        	session.getTransaction().commit();
        	if(session.isOpen()) {
        		session.close();
        	}
        }
    }
}
