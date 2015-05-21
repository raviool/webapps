package t124003.backend.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import t124003.backend.db.DBConnection;
import t124003.backend.model.Document;

//@Service("documentService")
public class DocumentService {
	private Connection c;
	
	public DocumentService() {}
	
	public DocumentService(Connection c) {
        try {
            this.setConnection(c);
        } catch(Exception e) {
        	// Log.
        }
    }
	
	public Document[] findAll() {
		/*Statement s = null;
		ResultSet rs = null;
		ArrayList<Tangerine> tangerines = new ArrayList<Tangerine>();
		String query = "select tangerine, type, varieties, description from tangerine order by tangerine;";
		
		try {
			s = DBConnection.getConnection().createStatement();
			rs = s.executeQuery(query);
			while(rs.next()) 
			{
			    Tangerine tangerine = new Tangerine();
			    tangerine.setId(rs.getInt("tangerine"));
			    tangerine.setType(rs.getString("type"));
			    tangerine.setVarieties(rs.getInt("varieties"));
			    tangerine.setDescription(rs.getString("description"));
			    tangerines.add(tangerine);
			}
		} catch (SQLException e) {
			l.error((new StringBuilder()).append("TangerineServiceImpl.findAll():").append(e.getMessage()).toString());
		}
		
		Tangerine[] tangerineArray = new Tangerine[tangerines.size()];
		
		for (int i=0; i<tangerines.size(); i++) {
			tangerineArray[i] = (Tangerine) tangerines.get(i);
		}
		
		return tangerineArray;*/
		
		return null;
	}
	
	public Document findById(int id) {
		Statement s = null;
		ResultSet rs = null;
		Document document = null;
		String query = "select document, name, description from document where document=" + id + ";";
		
		try {
			s = DBConnection.getConnection().createStatement();
			rs = s.executeQuery(query);
			while (rs.next()) {
				document = new Document();
				document.setDocument(rs.getInt("document"));
				document.setName(rs.getString("name"));
				document.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			// Log.
		}
		
        return document;
	}
	
	public void update(Document document) {
		/*Statement s = null;
		
		try {
			s = DBConnection.getConnection().createStatement();
			s.executeUpdate("update tangerine set type='" + tangerine.getType() + "', varieties=" + tangerine.getVarieties() + ", description='" + tangerine.getDescription() + "' where tangerine=" + tangerine.getId());
		} catch (SQLException e) {
			l.error((new StringBuilder()).append("TangerineServiceImpl.update():").append(e.getMessage()).toString());
		}*/
	}

	public Connection getConnection() {
		return c;
	}

	public void setConnection(Connection c) {
		this.c = c;
	}
}
