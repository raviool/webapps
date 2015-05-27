package t124003.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t124003.backend.model.document.DocCatalog;
import t124003.backend.service.DeleteDocumentService;
import t124003.backend.service.DocCatalogHibernateService;

import java.security.Principal;
import java.util.List;

/**
 * Created by Raviool on 26.05.2015.
 */
@Controller
public class DeleteDocumentController {

    @Autowired
    DocCatalogHibernateService docCatalogService;

    @Autowired
    DeleteDocumentService deleteDocumentService;

    @RequestMapping("delete")
    public String doGet(@RequestParam("doc") int docId, Model model, Principal principal) {
        System.out.println("deleting...");
        deleteDocumentService.deleteDocument(docId, principal.getName());

        return "redirect:?";
    }
}
