package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import t124003.backend.db.DBConnection;
import t124003.backend.model.document.DocType;
import t124003.backend.model.view.Subject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raviool on 26.05.2015.
 */
@Service("docSubjectRelationService")
public class DocSubjectRelationService {

    public List<Subject> getRelatedSubjects(int docId) {
        List<Subject> subjects = new ArrayList<Subject>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        String query = "SELECT * FROM relatedpersons WHERE document_fk=" + docId + ";";
        try {
            c = DBConnection.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(query);
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setRelationId(rs.getInt("doc_subject"));
                sub.setName(rs.getString("first_name") + " " + rs.getString("last_name"));
                sub.setNote(rs.getString("note"));
                sub.setType(rs.getString("type_name"));
                subjects.add(sub);
            }
        } catch (SQLException e) {
            //TODO: log
            //l.error((new StringBuilder()).append("DocStatusTypeService.findById(): ").append(e.getMessage()));
        } finally {
            DBConnection.close(c);
        }
        query = "SELECT * FROM relatedenterprises WHERE document_fk=" + docId + ";";
        try {
            c = DBConnection.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(query);
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setRelationId(rs.getInt("doc_subject"));
                sub.setName(rs.getString("full_name"));
                sub.setNote(rs.getString("note"));
                sub.setType(rs.getString("type_name"));
                subjects.add(sub);
            }
        } catch (SQLException e) {
            //TODO: log
            //l.error((new StringBuilder()).append("DocStatusTypeService.findById(): ").append(e.getMessage()));
        } finally {
            DBConnection.close(c);
        }
        return subjects;
    }

    public void deleteRelation(int relId, int docId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("DELETE DocSubject WHERE docSubject=:rel AND documentFk=:doc");
            q.setInteger("rel", relId);
            q.setInteger("doc", docId);
            q.executeUpdate();
        } finally {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

}
