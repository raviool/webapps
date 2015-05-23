package t124003.frontend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t124003.backend.model.document.DocSubjectRelationType;
import t124003.backend.model.subject.Person;
import t124003.backend.service.DocSubjectRelationTypeHibernateService;

import java.util.List;

/**
 * Created by Raviool on 23.05.2015.
 */
@Controller
public class SubjectSearchController {

    static Logger l = Logger.getLogger(SubjectSearchController.class.getName());


    @Autowired
    private DocSubjectRelationTypeHibernateService docSubjectRelationTypeService;

    @RequestMapping(value="/subjectSearch", method= RequestMethod.GET)
    public String getSubjectSearch(@ModelAttribute Person person, Model model) {
        List<DocSubjectRelationType> docSubjectRelationTypes;
        docSubjectRelationTypes = docSubjectRelationTypeService.findDocSubjectRelationTypes();
        model.addAttribute("person", person);
        model.addAttribute("docSubjectRelationTypes", docSubjectRelationTypes);
        return "subjectSearchForm";
    }
}
