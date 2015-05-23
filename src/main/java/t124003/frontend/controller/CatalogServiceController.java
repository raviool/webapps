package t124003.frontend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
public class CatalogServiceController {
	@Autowired
	private DocCatalogHibernateService docCatalogService;

	@RequestMapping(value="/catalog", method=RequestMethod.GET, params = {"id"})
	public void doGet(@RequestParam(value="id") int catalog_id, HttpServletResponse res) {
		List<Document> documents = findCatalogById(catalog_id);
		tangerineToJson(documents, res);
	}

	private List<Document> findCatalogById(int catalog_id) {
		DocCatalogHibernateService docCatalogService = new DocCatalogHibernateService();
		List<Document> documents = null;
		
		try {
			documents = docCatalogService.findDocumentsByCatalogId(catalog_id);
		} catch (NumberFormatException e) {
			// Log.
		}
		
		return documents;
	}
	
	private void tangerineToJson (List<Document> documents, HttpServletResponse res) {
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