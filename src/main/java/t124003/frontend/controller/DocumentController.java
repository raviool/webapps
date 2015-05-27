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
import t124003.backend.model.document.DocType;
import t124003.backend.model.document.Document;
import t124003.backend.model.subject.Person;
import t124003.backend.model.view.Subject;
import t124003.backend.service.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Raviool on 23.05.2015.
 */
@Controller
public class DocumentController {
    static Logger l = Logger.getLogger(DocumentController.class.getName());

    @Autowired
    private DocStatusTypeService docStatusTypeService;

    @Autowired
    private DocumentHibernateService documentService;

    @Autowired
    private DocAttributeHibernateService docAttributeService;

    @Autowired
    private DocSubjectRelationService docSubjectRelationService;

    @Autowired
    private StatusHibernateService statusService;
    
    /*@Autowired
    private DocSubjectRelationTypeHibernateService docSubjectRelationTypeService;*/

    @RequestMapping(value="/s", method= RequestMethod.GET, params = {"id"})
    public String getDocument(@RequestParam(value="id") String document_id, @ModelAttribute DocType docStatusType, @ModelAttribute Person person, Model model) throws SQLException {
        Document document;
        DocType docType;
        List<Subject> docSubjects;
        //List<DocSubjectRelationType> docSubjectRelationTypes;
        //docSubjectRelationTypes = docSubjectRelationTypeService.findDocSubjectRelationTypes();
        List<DocAttribute> docAttributes;
        try {
            document = documentService.findById(Integer.parseInt(document_id));
            docType = documentService.findDocType(document);
            docStatusType = docStatusTypeService.findById(Integer.parseInt(document_id));
            docAttributes = docAttributeService.findDocumentAttributes(Integer.parseInt(document_id));
            docSubjects = docSubjectRelationService.getRelatedSubjects(Integer.parseInt(document_id));
            for (DocAttribute da: docAttributes) {
                da.setSelectionValues(docAttributeService.findSelectionAttributeValues(da));
            }
        } catch (NumberFormatException e) {
            l.error((new StringBuilder()).append("DefaultController.getDocument(): ").append(e.getMessage()));
            return "error";
        }
        if (document != null) {
            List<DocStatusType> statuses = statusService.getStatuses();
            model.addAttribute("document", document);
            model.addAttribute("docStatusType", docStatusType);
            model.addAttribute("docAttributes", docAttributes);
            model.addAttribute("docType", docType);
            model.addAttribute("person", person);
            model.addAttribute("subjects", docSubjects);
            model.addAttribute("statuses", statuses);
            //model.addAttribute("docSubjectRelationTypes", docSubjectRelationTypes);
            return "documentForm";
        } else {
            l.error((new StringBuilder()).append("DefaultController.getDocument(): ").append("Dokumenti ei eksisteeri."));
            return "error";
        }
    }
}
