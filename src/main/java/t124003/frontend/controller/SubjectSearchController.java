package t124003.frontend.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import t124003.backend.model.document.DocSubject;
import t124003.backend.model.document.DocSubjectRelationType;
import t124003.backend.service.*;
import t124003.backend.service.sessionmanagement.CustomUserDetails;
import t124003.frontend.validator.DocumentValidator;

/**
 * @author Dan
 */
@Controller
public class SubjectSearchController {
	static Logger l = Logger.getLogger(SubjectSearchController.class.getName());

	@Autowired
	private DocSubjectRelationTypeHibernateService docSubjectRelationTypeService;
	
	@Autowired
	private DocSubjectHibernateService docSubjectService;
	
	@RequestMapping(value="/subjectSearch", method=RequestMethod.GET, params={"subject", "document", "type"})
	public String getSubjectSearch(@RequestParam(value="subject", required = true) int subject,
								   @RequestParam(value="document", required = true) int document,
								   @RequestParam(value="type", required = true) int type,
								   Model model) {
		List<DocSubjectRelationType> docSubjectRelationTypes;
		DocSubject docSubject = new DocSubject();
		docSubject.setSubjectFk(subject);
		docSubject.setDocumentFk(document);
		docSubject.setDocSubjectTypeFk(type);
		docSubjectRelationTypes = docSubjectRelationTypeService.findDocSubjectRelationTypes();
		model.addAttribute("docSubjectRelationTypes", docSubjectRelationTypes);
		model.addAttribute("docSubject", docSubject);
		return "subjectSearchForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String updateDocSubjectRelations(@RequestParam(value="subject", required = true) int subject,
										    @RequestParam(value="document", required = true) int document,
										    @RequestParam(value="type", required = true) int type,
										    @RequestParam(value="relation", required = true) String relation,
										    HttpServletRequest req,
										    Model model) throws SQLException {
		DocumentValidator documentValidator = new DocumentValidator();
		HashMap<String, String> searchErrors = new HashMap<String, String>();
		
		searchErrors = documentValidator.ValidateSearch(req.getParameter("note"));
		
		if(searchErrors.size() > 0) {
			String noteError = "";
			if (searchErrors.get("note") != null) {
				noteError = (String) searchErrors.get("note");
			}
			req.setAttribute("noteError", noteError);
			req.setAttribute("note", req.getParameter("note"));
			
			return getSubjectSearch(subject, document, type, model);
		} else {
			DocSubject docSubject = new DocSubject();

			docSubject.setSubjectFk(subject);
			docSubject.setDocumentFk(document);
			docSubject.setDocSubjectTypeFk(type);
			DocSubjectRelationType docSubjectRelationType = docSubjectRelationTypeService.findDocSubjectRelationTypeByTypeName(relation);
			docSubject.setDocSubjectRelationTypeFk(docSubjectRelationType.getDocSubjectRelationType());
			docSubject.setNote(req.getParameter("note"));
			
			docSubjectService.insertDocSubject(docSubject);
			
			return "redirect:/s?id=" + document;
		}
	}
}