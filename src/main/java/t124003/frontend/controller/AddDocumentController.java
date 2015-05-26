package t124003.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import t124003.backend.model.document.*;
import t124003.backend.service.*;
import t124003.backend.service.sessionmanagement.CustomUserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raviool on 26.05.2015.
 */
@Controller
public class AddDocumentController {

    @Autowired
    DocCatalogHibernateService docCatalogHibernateService;

    @Autowired
    DocTypeHibernateService docTypeHibernateService;

    @Autowired
    DocAttributeHibernateService docAttributeService;

    @Autowired
    DocumentHibernateService documentService;

    @Autowired
    StatusHibernateService statusService;

    @Autowired
    AddDocumentService addDocumentService;


    @RequestMapping(value = "/addtypeselection", method = RequestMethod.GET)
    public String doGet(@RequestParam("catalog") int catalog, Model model) {
        DocCatalog docCatalog = docCatalogHibernateService.findCatalog(catalog);
        model.addAttribute("catalog", docCatalog);
        List<DocType> docTypes = docTypeHibernateService.findUsableDocTypes();
        model.addAttribute("doctypes", docTypes);
        return "docTypeForm";
    }

    @RequestMapping(value = "/documentadd", method = RequestMethod.GET)
    public String doGet(@RequestParam("catalog") int catalog, @RequestParam("type") int type, Model model) {
        List<DocAttributeType> docAttributeTypes = docAttributeService.findDocumentTypeAttributes(type);
        DocCatalog docCatalog = docCatalogHibernateService.findCatalog(catalog);
        DocType docType;
        docType = documentService.findDocType(type);
        List<DocStatusType> statuses = statusService.getStatuses();
        model.addAttribute("docAttributes", docAttributeTypes);
        model.addAttribute("catalog", catalog);
        model.addAttribute("type", type);
        model.addAttribute("docType", docType);
        model.addAttribute("docCatalog", docCatalog);
        model.addAttribute("statuses", statuses);
        for (DocAttributeType dat: docAttributeTypes) {
            dat.setSelectionValues(docAttributeService.findSelectionAttributeValues(dat));
        }
        return "docAddForm";
    }

    @RequestMapping(value = "/documentadd", method = RequestMethod.POST, params = {"add"})
    public String doPost(Model model, HttpServletRequest req) {
        addDocumentService.addDocumentFromRequest(req, (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return doGet(Integer.parseInt(req.getParameter("catalog")), Integer.parseInt(req.getParameter("type")), model);
    }

}
