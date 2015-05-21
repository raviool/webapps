package t124003.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import t124003.backend.model.DocAttribute;
import t124003.backend.model.DocType;
import t124003.backend.model.Document;
import t124003.backend.service.DocAttributeHibernateService;
import t124003.backend.service.DocStatusTypeService;
import t124003.backend.service.DocumentHibernateService;

import java.util.List;

@Controller
public class DefaultController {

	@Autowired
	private DocumentHibernateService documentService;

	@Autowired
	private DocStatusTypeService docStatusTypeService;

	@Autowired
	private DocAttributeHibernateService docAttributeService;

	Document document;
	DocType docType;
	List<DocAttribute> docAttributes;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getDocuments(Model model) {
		return "mainForm";
	}

	/* Document juhendis doc_attribute alamsektsioon.
	   Antud meetodis tuleb veel realiseerida saatjad, vastamise tähtaeg ja formaat nagu pildil juhendis.
	   Tähelepanu tuleb juhtida asjaolule, et iga dokumendi atribuudid sõltuvad selle tüübist ning valitakse tabelist eraldi vms.
	   Seega tuleks see ka siin realiseerida.*/

	@RequestMapping(value="/s", method=RequestMethod.GET, params = {"id"})
	public String getDocument(@RequestParam(value="id") String document_id, @ModelAttribute DocType docStatusType, Model model) {
		try {
			/* Kui siia lisada mingi uus objekt (va. dokument, mis on kirjeldatud .jsp failis) koos vastava teenusega, 
			   siis tuleb ülesse lisada vastav ModelAttribute.*/
			document = documentService.findById(Integer.parseInt(document_id));
			docStatusType = docStatusTypeService.findById(Integer.parseInt(document_id));
			docAttributes = docAttributeService.findDocumentAttributes(Integer.parseInt(document_id));
			docType = documentService.findDocType(document);
			for (DocAttribute da: docAttributes) {
				da.setSelectionValues(docAttributeService.findSelectionAttributeValues(da));
			}
			// Kui otsitav objekt vastab mingile klassile, tuleks see eraldi luua nagu docType puhul.
		} catch (NumberFormatException e) {
			// Log.
			return "error";
		}
		if (document != null) {
			model.addAttribute("document", document);
			model.addAttribute("docStatusType", docStatusType);
			model.addAttribute("docAttributes", docAttributes);
			model.addAttribute("docType", docType);
			return "documentForm";
		} else {
			// Log.
			return "error";
		}
	}
}