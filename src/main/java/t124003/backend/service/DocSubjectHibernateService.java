package t124003.backend.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
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
            //Query q = session.createSQLQuery("SELECT create_subject_relation(" + docSubject.getDocumentFk() + ", " + docSubject.getDocSubjectTypeFk() + ", " + docSubject.getSubjectFk() + ", " + docSubject.getDocSubjectRelationTypeFk() + ", '" + docSubject.getNote() + "');");
            Query q = session.createSQLQuery("SELECT create_subject_relation(:doc_id, :sub_type, :sub_id, :rel_type, :note);")
            		.addScalar("doc_id", IntegerType.INSTANCE)
            		.addScalar("sub_type", IntegerType.INSTANCE)
            		.addScalar("sub_id", IntegerType.INSTANCE)
            		.addScalar("rel_type", IntegerType.INSTANCE)
            		.addScalar("note", StringType.INSTANCE);
            q.setInteger("doc_id", docSubject.getDocumentFk());
            q.setInteger("sub_type", docSubject.getDocSubjectTypeFk());
            q.setInteger("sub_id", docSubject.getSubjectFk());
            q.setInteger("rel_type", docSubject.getDocSubjectRelationTypeFk());
            q.setString("note", docSubject.getNote());
            try {
            	q.list();
            } catch (SQLGrammarException e) {}
        } finally {
        	session.getTransaction().commit();
        	if(session.isOpen()) {
        		session.close();
        	}
        }
    }
}
