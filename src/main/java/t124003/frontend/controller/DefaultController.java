package t124003.frontend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import t124003.backend.model.document.DocAttribute;
import t124003.backend.model.document.DocStatusType;
import t124003.backend.model.document.DocSubjectRelationType;
import t124003.backend.model.document.DocType;
import t124003.backend.model.document.Document;
import t124003.backend.model.subject.Person;
import t124003.backend.service.DocAttributeHibernateService;
import t124003.backend.service.DocStatusTypeHibernateService;
import t124003.backend.service.DocStatusTypeService;
import t124003.backend.service.DocSubjectRelationTypeHibernateService;
import t124003.backend.service.DocTypeHibernateService;
import t124003.backend.service.DocumentHibernateService;

import java.util.List;

@Controller
public class DefaultController {
	static Logger l = Logger.getLogger("t124003.frontend.controller/DefaultController");
	
	@Autowired
	private DocStatusTypeService docStatusTypeService;
	
	// TODO: docStatusTypeService meetodid tuleks lisada antud service alla, et terve veebirakendus kasutaks Hibernate.
	@Autowired
	private DocStatusTypeHibernateService docStatusTypeHibernateService;
	
	@Autowired
	private DocumentHibernateService documentService;

	@Autowired
	private DocAttributeHibernateService docAttributeService;
	
	@Autowired
	private DocSubjectRelationTypeHibernateService docSubjectRelationTypeService;
	
	@Autowired
	private DocTypeHibernateService docTypeService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getDocuments(Model model) {
		return "mainForm";
	}
	
	@RequestMapping(value="/subjectSearch", method=RequestMethod.GET)
	public String getSubjectSearch(@ModelAttribute Person person, Model model) {
		List<DocSubjectRelationType> docSubjectRelationTypes;
		docSubjectRelationTypes = docSubjectRelationTypeService.findDocSubjectRelationTypes();
		model.addAttribute("person", person);
		model.addAttribute("docSubjectRelationTypes", docSubjectRelationTypes);
		return "subjectSearchForm";
	}
	
	@RequestMapping(value="/documentSearch", method=RequestMethod.GET)
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

	@RequestMapping(value="/s", method=RequestMethod.GET, params = {"id"})
	public String getDocument(@RequestParam(value="id") String document_id, @ModelAttribute DocType docStatusType, Model model) {
		Document document;
		DocType docType;
		List<DocAttribute> docAttributes;
		try {
			document = documentService.findById(Integer.parseInt(document_id));
			docType = documentService.findDocType(document);
			docStatusType = docStatusTypeService.findById(Integer.parseInt(document_id));
			docAttributes = docAttributeService.findDocumentAttributes(Integer.parseInt(document_id));
			for (DocAttribute da: docAttributes) {
				da.setSelectionValues(docAttributeService.findSelectionAttributeValues(da));
			}
		} catch (NumberFormatException e) {
			l.error((new StringBuilder()).append("DefaultController.getDocument(): ").append(e.getMessage()));
			return "error";
		}
		if (document != null) {
			model.addAttribute("document", document);
			model.addAttribute("docStatusType", docStatusType);
			model.addAttribute("docAttributes", docAttributes);
			model.addAttribute("docType", docType);
			return "documentForm";
		} else {
			l.error((new StringBuilder()).append("DefaultController.getDocument(): ").append("Dokumenti ei eksisteeri."));
			return "error";
		}
	}
}