package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 * Created by Raviool on 26.05.2015.
 */
@Service("updateDateService")
public class UpdateDateService {

    public void updateCatalogEditDate(String username, int catalogId) {
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

            System.out.println("employee:" + employee);
            System.out.println("person:" + person);
            System.out.println("catalog:" + catalogId);

            q = session.createSQLQuery("UPDATE doc_catalog SET content_updated=current_timestamp, content_updated_by=:employee WHERE doc_catalog=:catalog");
            q.setInteger("employee", employee);
            q.setInteger("catalog", catalogId);
            System.out.println("executing...");
            q.executeUpdate();
            System.out.println("executed");
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateDocEditDate(String username, int documentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer catalog = null;
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
            q = session.createQuery("UPDATE Document SET updated=current_timestamp, updatedBy=:employee WHERE document=:document");
            q.setInteger("employee", employee);
            q.setInteger("document", documentId);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    //Eeldame, et dokument on juba pandud andmebaasi, seega documentId on olemas
    public void updateDocCreateDate(String username, int documentId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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
            q = session.createQuery("UPDATE Document SET created=current_timestamp, createdBy=:employee WHERE document=:catalogId");
            q.setInteger("employee", employee);
            q.setInteger("catalogId", documentId);
            q.executeUpdate();
            //Update catalog also
            q = session.createQuery("SELECT docCatalogFk FROM DocumentDocCatalog WHERE documentFk=:documentId");
            q.setInteger("documentId", documentId);
            Integer catalog = (Integer) q.uniqueResult();
            updateCatalogEditDate(username, catalog);

        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
