package t124003.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t124003.backend.service.DocCatalogHibernateService;
import t124003.backend.service.StatusUpdateService;
import t124003.backend.service.UpdateDateService;

import java.security.Principal;
import java.sql.SQLException;

/**
 * Created by Raviool on 26.05.2015.
 */
@Controller
public class TestbedController {

    @Autowired
    UpdateDateService updateDateService;

    @Autowired
    DocCatalogHibernateService docCatalogHibernateService;

    @Autowired
    StatusUpdateService statusUpdateService;

    @RequestMapping(value="/testbed", method= RequestMethod.GET)
    public void doGet(Principal principal) throws SQLException {
        /*
        //Testing date updating methods
        System.out.println("Updating: " + principal.getName());
        updateDateService.updateDocCreateDate(principal.getName(), 2);
        System.out.print("getting catalog");
        Integer catalog = docCatalogHibernateService.findDocumentCatalog(2);
        System.out.println(catalog);
        updateDateService.updateCatalogEditDate(principal.getName(), catalog);
        */

        /*
        //Status history update
        statusUpdateService.updateDocumentStatusHistory(1, 1, principal.getName());
        */


    }
}
