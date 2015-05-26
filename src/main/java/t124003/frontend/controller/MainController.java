package t124003.frontend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import t124003.backend.model.document.*;
import t124003.backend.model.subject.Person;
import t124003.backend.service.*;
import t124003.backend.service.sessionmanagement.CustomUserDetails;

import javax.servlet.http.HttpSession;
import java.nio.Buffer;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {
	static Logger l = Logger.getLogger(MainController.class.getName());

	@Autowired
	private DocCatalogHibernateService docCatalogService;

	@Autowired
	private BufferService bufferService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getDocuments(Model model, Principal principal) {
		model.addAttribute("session", principal.getName());
		List<DocCatalog> docRootCatalogs;
		List<DocCatalog> docSecondLevelCatalogs;
		docRootCatalogs = docCatalogService.findNthLevelCatalogs(1);
		docSecondLevelCatalogs = docCatalogService.findNthLevelCatalogs(2);
		model.addAttribute("docRootCatalogs", docRootCatalogs);
		model.addAttribute("docSecondLevelCatalogs", docSecondLevelCatalogs);
		return "mainForm";
	}

	@RequestMapping(value="/", method = RequestMethod.POST)
	public String addToBuffer(@RequestParam(value = "buffer", required = false) String[] buffer, Principal principal, Model model) {
		if (buffer == null) {
			return getDocuments(model, principal);
		}
		HashSet<Integer> bufferSet = new HashSet<Integer>();
		for (String s: buffer) {
			bufferSet.add(Integer.parseInt(s));
		}
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setBuffer(bufferSet);
		return getDocuments(model, principal);
	}

	@RequestMapping(value="/buffer", method = RequestMethod.POST)
	public String addtoBuffer(@RequestParam("movecatalog") int catalog, Principal principal, Model model) {
		bufferService.moveDocuments((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal(), catalog, principal.getName());
		return getDocuments(model, principal);
	}
}