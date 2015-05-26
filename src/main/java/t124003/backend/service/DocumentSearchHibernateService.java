package t124003.backend.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import t124003.backend.db.DBConnection;
import t124003.backend.model.view.Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service("documentSearchHibernateService")
public class DocumentSearchHibernateService {
	static Logger l = Logger.getLogger(DocumentSearchHibernateService.class.getName());

    public DocumentSearchHibernateService() {};

	public List<Result> findDocuments(String query) {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		Result result;
		List<Result> results = new ArrayList<Result>();
		
		try {
			c = DBConnection.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			while (rs.next()) {
				result = new Result();
				result.setDocument(rs.getInt("document"));
				result.setName(rs.getString("name"));
				result.setDescription(rs.getString("description"));
				result.setLast_name(rs.getString("last_name"));
				result.setDoc_catalog_name(rs.getString("doc_catalog_name"));
				result.setDoc_status(rs.getString("doc_status"));
				result.setDoc_type(rs.getString("doc_type"));
				results.add(result);
			}
		} catch (SQLException e) {
        	l.error((new StringBuilder()).append("DocumentSearchHibernateService.findDocuments(): ").append(e.getMessage()));
		} finally {
			DBConnection.close(c);
		}
		
        return results;
	}
}
