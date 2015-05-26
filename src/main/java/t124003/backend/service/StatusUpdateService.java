package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

/**
 * Created by Raviool on 26.05.2015.
 */
@Service("statusUpdateService")
public class StatusUpdateService {
    public void updateDocumentStatusHistory(int document, int status, String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            //Subjekti id (person)
            Query q = session.createQuery("SELECT subjectFk FROM UserAccount WHERE username=:username AND subjectTypeFk = 3");
            q.setString("username", username);
            Integer person = (Integer) q.uniqueResult();
            //Töötaja id (employee)
            q = session.createQuery("SELECT employee FROM Employee WHERE personFk=:person");
            q.setInteger("person", person);
            Integer employee = (Integer) q.uniqueResult();

            q = session.createQuery("UPDATE DocStatus SET statusEnd=current_timestamp WHERE documentFk=:document AND statusEnd IS null");
            q.setInteger("document", document);
            q.executeUpdate();
            q = session.createSQLQuery("INSERT INTO doc_status (document_fk, doc_status_type_fk, status_begin, created_by) VALUES (:document, :status, current_timestamp, :employee)");
            q.setInteger("document", document);
            q.setInteger("status", status);
            q.setInteger("employee", employee);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
