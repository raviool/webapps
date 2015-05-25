package t124003.backend.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import t124003.backend.db.DBConnection;
import t124003.backend.model.document.DocType;

@Service("docTypeService")
public class DocStatusTypeService {
	private Connection c;
	
	public DocStatusTypeService() {}
	
	public DocStatusTypeService(Connection c) {
        try {
            this.setConnection(c);
        } catch(Exception e) {
        	// Log.
        }
    }
	
	public DocType findById(int id) throws SQLException {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		DocType docType = null;
		String query = "select type_name from doc_status_type where doc_status_type=(select doc_status_type_fk from document where document=" + id + ");";
		
		try {
			c = DBConnection.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(query);
			while (rs.next()) {
				docType = new DocType();
				docType.setTypeName(rs.getString("type_name"));
			}
		} catch (SQLException e) {
			// Log.
		} finally {
			DBConnection.close(c);
		}
		
        return docType;
	}
	
	public Connection getConnection() {
		return c;
	}

	public void setConnection(Connection c) {
		this.c = c;
	}
}
