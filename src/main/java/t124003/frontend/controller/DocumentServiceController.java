package t124003.frontend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import t124003.backend.model.document.Document;
import t124003.backend.service.*;

@Controller
public class DocumentServiceController {

	static Logger l = Logger.getLogger(DocumentServiceController.class.getName());

	@Autowired
	private DocumentSearchHibernateService documentSearchService;
	
    @RequestMapping(value="/documentSearch", method= RequestMethod.GET)
    public void doGetDocuments(@RequestParam(value="id", required = false) int id,
    						   @RequestParam(value="name", required = false) String name,
    						   @RequestParam(value="description", required = false) String description,
    						   @RequestParam(value="last_name", required = false) String last_name,
    						   @RequestParam(value="doc_catalog_name", required = false) String doc_catalog_name,
    						   @RequestParam(value="doc_status", required = false) String doc_status,
    						   @RequestParam(value="doc_type", required = false) String doc_type,
    						   HttpServletResponse res) throws SQLException {
    	String query = "SELECT * FROM documentsearch";
    	List<Document> documents;
		if (id != 0 || 
			!name.equals("") ||
			!description.equals("") ||
			!last_name.equals("") ||
			!doc_catalog_name.equals("") ||
			!doc_status.equals("") ||
			!doc_type.equals("")) {
			query += " WHERE";
		}
		if (id != 0) {
			query += " AND document=" + id;
		}
		if (!name.equals("")) {
			query += " AND name=" + name;
		}
		if (!description.equals("")) {
			query += " AND CONTAINS(description, '" + description + "')";
		}
		if (!last_name.equals("")) {
			query += " AND last_name LIKE '" + last_name + "%'";
		}
		if (!doc_catalog_name.equals("")) {
			query += " AND doc_catalog_name=" + doc_catalog_name;
		}
		if (!doc_status.equals("")) {
			query += " AND doc_status=" + doc_status;
		}
		if (!doc_type.equals("")) {
			query += " AND doc_type=" + doc_type;
		}
		query += ";";
		
		documents = findDocuments(query);
		
		catalogToJson(documents, res);
    }

	private List<Document> findDocuments(String query) {
		DocumentSearchHibernateService documentSearchService = new DocumentSearchHibernateService();
		List<Document> documents = null;

		try {
			documents = documentSearchService.findDocuments(query);
		} catch (NumberFormatException e) {
			// Log.
		}

		return documents;
	}
	
	private void catalogToJson (List<Document> documents, HttpServletResponse res) {
		Gson gson = new Gson();
		PrintWriter pw = null;
		
		try {
			pw = res.getWriter();
		} catch (IOException e) {
			// Log.
		}
		
		String json = gson.toJson(documents);
		pw.print(json);
	}
	
	public String goPage(Model m) throws SQLException {
		return null;
	}
}