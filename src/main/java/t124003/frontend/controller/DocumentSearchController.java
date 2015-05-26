package t124003.frontend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import t124003.backend.model.document.DocStatusType;
import t124003.backend.model.document.DocType;
import t124003.backend.model.document.Document;
import t124003.backend.model.view.Result;
import t124003.backend.service.*;

@Controller
public class DocumentSearchController {

	static Logger l = Logger.getLogger(DocumentSearchController.class.getName());

	@Autowired
	private DocumentSearchHibernateService documentSearchService;

	@Autowired
	private DocStatusTypeHibernateService docStatusTypeHibernateService;

	@Autowired
	private DocTypeHibernateService docTypeService;
	
	@RequestMapping(value="/documentSearch", method= RequestMethod.GET)
	public String getDocumentSearch(@ModelAttribute Document document, Model model) {
		List<DocType> docTypes;
		docTypes = docTypeService.findDocTypes();
		List<DocStatusType> docStatusTypes;
		docStatusTypes = docStatusTypeHibernateService.findDocStatusTypes();
		model.addAttribute("document", document);
		model.addAttribute("docTypes", docTypes);
		model.addAttribute("docStatusTypes", docStatusTypes);
		return "documentSearchForm";
	}
	
    @RequestMapping(value="/documentSearch", method= RequestMethod.GET, params = {"id", "name", "description", "last_name", "doc_catalog_name", "doc_status", "doc_type"})
    public void doGetDocuments(@RequestParam(value="id", required = true) String id,
    						   @RequestParam(value="name", required = true) String name,
    						   @RequestParam(value="description", required = true) String description,
    						   @RequestParam(value="last_name", required = true) String last_name,
    						   @RequestParam(value="doc_catalog_name", required = true) String doc_catalog_name,
    						   @RequestParam(value="doc_status", required = true) String doc_status,
    						   @RequestParam(value="doc_type", required = true) String doc_type,
    						   HttpServletResponse res) throws SQLException {
    	String query = "SELECT * FROM documentsearch";
    	List<Result> results;
    	System.out.println(id);
		if (!id.equals("") || 
			!name.equals("") ||
			!description.equals("") ||
			!last_name.equals("") ||
			!doc_catalog_name.equals("") ||
			!doc_status.equals("") ||
			!doc_type.equals("")) {
			query += " WHERE";
			int i = 0;
			if (!id.equals("")) {
				if (i == 0) {
					query += " document=" + id;
					i++;
				} else {
					query += " AND document=" + id;
					i++;
				}
			}
			if (!name.equals("")) {
				if (i == 0) {
					query += " name='" + name + "'";
					i++;
				} else {
					query += " AND name='" + name + "'";
					i++;
				}
			}
			if (!description.equals("")) {
				if (i == 0) {
					query += " CONTAINS(description, '" + description + "')";
					i++;
				} else {
					query += " AND CONTAINS(description, '" + description + "')";
					i++;
				}
			}
			if (!last_name.equals("")) {
				if (i == 0) {
					query += " last_name LIKE '" + last_name + "%'";
					i++;
				} else {
					query += " AND last_name LIKE '" + last_name + "%'";
					i++;
				}
			}
			if (!doc_catalog_name.equals("")) {
				if (i == 0) {
					query += " doc_catalog_name='" + doc_catalog_name + "'";
					i++;
				} else {
					query += " AND doc_catalog_name='" + doc_catalog_name + "'";
					i++;
				}
				
			}
			if (!doc_status.equals("")) {
				if (i == 0) {
					query += " doc_status='" + doc_status + "'";
					i++;
				} else {
					query += " AND doc_status='" + doc_status + "'";
					i++;
				}
			}
			if (!doc_type.equals("")) {
				if (i == 0) {
					query += " doc_type='" + doc_type + "'";
					i++;
				} else {
					query += " AND doc_type='" + doc_type + "'";
					i++;
				}
			}
			
		}
		
		query += ";";
		
		results = findDocuments(query);
		
		documentsToJson(results, res);
    }

	private List<Result> findDocuments(String query) {
		DocumentSearchHibernateService documentSearchService = new DocumentSearchHibernateService();
		List<Result> results = null;

		try {
			results = documentSearchService.findDocuments(query);
		} catch (NumberFormatException e) {
        	l.error((new StringBuilder()).append("DocumentSearchController.findDocuments(): ").append(e.getMessage()));
		}

		return results;
	}
	
	private void documentsToJson (List<Result> results, HttpServletResponse res) {
		Gson gson = new Gson();
		PrintWriter pw = null;
		
		try {
			pw = res.getWriter();
		} catch (IOException e) {
        	l.error((new StringBuilder()).append("DocumentSearchController.documentsToJson(): ").append(e.getMessage()));
		}
		
		String json = gson.toJson(results);
		pw.print(json);
	}
	
	public String goPage(Model m) throws SQLException {
		return null;
	}
}