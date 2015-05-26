package t124003.frontend.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import t124003.backend.model.document.DocSubject;
import t124003.backend.model.document.DocSubjectRelationType;
import t124003.backend.service.*;

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
										    @RequestParam(value="note", required = true) String note,
										    Model model) throws SQLException {
		DocSubject docSubject = new DocSubject();

		docSubject.setSubjectFk(subject);
		docSubject.setDocumentFk(document);
		docSubject.setDocSubjectTypeFk(type);
		DocSubjectRelationType docSubjectRelationType = docSubjectRelationTypeService.findDocSubjectRelationTypeByTypeName(relation);
		docSubject.setDocSubjectRelationTypeFk(docSubjectRelationType.getDocSubjectRelationType());
		docSubject.setNote(note);
		
		docSubjectService.insertDocSubject(docSubject);
		
		return "redirect:/s?id=" + document;
	}
}