package t124003.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t124003.backend.service.EditDocumentService;
import t124003.backend.service.sessionmanagement.CustomUserDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Raviool on 27.05.2015.
 */
@Controller
public class EditDocumentController {

@Autowired
private EditDocumentService editDocumentService;

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String doPost(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        editDocumentService.editDocumentFromRequest(req, (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "redirect:s?id=" + id;
    }
}
