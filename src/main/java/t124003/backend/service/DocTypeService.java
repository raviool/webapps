package t124003.backend.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import t124003.backend.db.DBConnection;
import t124003.backend.model.DocType;

@Service("docTypeService")
public class DocTypeService {
	private Connection c;
	
	public DocTypeService() {}
	
	public DocTypeService(Connection c) {
        try {
            this.setConnection(c);
        } catch(Exception e) {
        	// Log.
        }
    }
	
	public DocType findById(int id) {
		Statement s = null;
		ResultSet rs = null;
		DocType docType = null;
		String query = "select type_name from doc_type where doc_type=(select doc_type_fk from document_doc_type where document_fk=" + id + ");";
		
		try {
			s = DBConnection.getConnection().createStatement();
			rs = s.executeQuery(query);
			while (rs.next()) {
				docType = new DocType();
				docType.setTypeName(rs.getString("type_name"));
			}
		} catch (SQLException e) {
			// Log.
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
