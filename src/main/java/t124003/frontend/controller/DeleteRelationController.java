package t124003.frontend.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t124003.backend.service.DocSubjectRelationService;
import t124003.backend.service.HibernateUtil;

/**
 * Created by Raviool on 27.05.2015.
 */
@Controller
public class DeleteRelationController {

    @Autowired
    DocSubjectRelationService docSubjectRelationService;

    @RequestMapping("/deleterel")
    public String deleteRelation(@RequestParam("id") int relId, @RequestParam("doc") int docId) {
        docSubjectRelationService.deleteRelation(relId, docId);
        return "redirect:/s?id=" + docId;
    }
}
