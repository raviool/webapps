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

/**
 * @author Dan
 */
@Controller
public class CatalogServiceController {
	static Logger l = Logger.getLogger(CatalogServiceController.class.getName());

	@Autowired
	private DocCatalogHibernateService docCatalogService;

	@RequestMapping(value="/catalog", method=RequestMethod.GET)
	public void doGet(@RequestParam(value="id", required = true) int catalog_id, HttpServletResponse res) throws SQLException {
		List<Document> documents;
		if (catalog_id <= 0) {
			documents = findAllDocuments();
		} else {
			documents = findCatalogById(catalog_id);
		}
		catalogToJson(documents, res);
	}

	private List<Document> findCatalogById(int catalog_id) throws SQLException {
		DocCatalogHibernateService docCatalogService = new DocCatalogHibernateService();
		List<Document> documents = null;
		
		try {
			documents = docCatalogService.findDocumentsByCatalogId(catalog_id);
		} catch (NumberFormatException e) {
        	l.error((new StringBuilder()).append("CatalogServiceController.doGet(): ").append(e.getMessage()));
		}
		
		return documents;
	}

	private List<Document> findAllDocuments() {
		DocCatalogHibernateService docCatalogService = new DocCatalogHibernateService();
		List<Document> documents = null;

		try {
			documents = docCatalogService.findAllDocuments();
		} catch (NumberFormatException e) {
        	l.error((new StringBuilder()).append("CatalogServiceController.findAllDocuments(): ").append(e.getMessage()));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return documents;
	}
	
	private void catalogToJson (List<Document> documents, HttpServletResponse res) {
		Gson gson = new Gson();
		PrintWriter pw = null;
		
		try {
			pw = res.getWriter();
		} catch (IOException e) {
        	l.error((new StringBuilder()).append("CatalogServiceController.catalogToJson(): ").append(e.getMessage()));
		}
		
		String json = gson.toJson(documents);
		pw.print(json);
	}
	
	public String goPage(Model m) throws SQLException {
		return null;
	}
}