package t124003.frontend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t124003.backend.model.document.DocStatusType;
import t124003.backend.model.document.DocType;
import t124003.backend.model.document.Document;
import t124003.backend.service.DocStatusTypeHibernateService;
import t124003.backend.service.DocTypeHibernateService;

import java.util.List;

/**
 * Created by Raviool on 23.05.2015.
 */
@Controller
public class DocumentSearchController {

    static Logger l = Logger.getLogger(DocumentSearchController.class.getName());

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

}
