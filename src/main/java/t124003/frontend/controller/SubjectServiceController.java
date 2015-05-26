package t124003.frontend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import t124003.backend.model.subject.Enterprise;
import t124003.backend.model.subject.Person;
import t124003.backend.service.*;

/**
 * @author Dan
 */
@Controller
public class SubjectServiceController {

	static Logger l = Logger.getLogger(SubjectServiceController.class.getName());

	@Autowired
	private DocCatalogHibernateService docCatalogService;

	@RequestMapping(value="/persons", method=RequestMethod.GET)
	public void doGetPersons(@RequestParam(value="name", required = true) String name, HttpServletResponse res) throws SQLException {
		List<Person> persons;
		if (name == null || name.equals("")) {
			System.out.println("finding all");
			persons = findAllPersons();
		} else {
			persons = findPersonsByName(name);
		}
		personToJson(persons, res);
	}

	private List<Person> findPersonsByName(String name) throws SQLException {
		PersonHibernateService personService = new PersonHibernateService();
		List<Person> persons = null;
		
		try {
			persons = personService.findPersonsByName(name);
		} catch (NumberFormatException e) {
        	l.error((new StringBuilder()).append("SubjectServiceController.findPersonsByName(): ").append(e.getMessage()));
		}
		
		return persons;
	}

	private List<Person> findAllPersons() {
		PersonHibernateService personService = new PersonHibernateService();
		List<Person> persons = null;

		try {
			persons = personService.findAllPersons();
		} catch (NumberFormatException e) {
        	l.error((new StringBuilder()).append("SubjectServiceController.findAllPersons(): ").append(e.getMessage()));
		}

		return persons;
	}
	
	private void personToJson (List<Person> persons, HttpServletResponse res) {
		Gson gson = new Gson();
		PrintWriter pw = null;
		
		try {
			pw = res.getWriter();
		} catch (IOException e) {
        	l.error((new StringBuilder()).append("SubjectServiceController.personToJson(): ").append(e.getMessage()));
		}
		
		String json = gson.toJson(persons);
		pw.print(json);
	}
	
	@RequestMapping(value="/enterprises", method=RequestMethod.GET)
	public void doGetEnterprises(@RequestParam(value="name", required = true) String name, HttpServletResponse res) throws SQLException {
		List<Enterprise> enterprises;
		if (name == null) {
			enterprises = findAllEnterprises();
		} else {
			enterprises = findEnterprisesByName(name);
		}
		enterpriseToJson(enterprises, res);
	}

	private List<Enterprise> findEnterprisesByName(String name) throws SQLException {
		EnterpriseHibernateService enterpriseService = new EnterpriseHibernateService();
		List<Enterprise> enterprises = null;
		
		try {
			enterprises = enterpriseService.findEnterprisesByName(name);
		} catch (NumberFormatException e) {
        	l.error((new StringBuilder()).append("SubjectServiceController.findEnterprisesByName(): ").append(e.getMessage()));
		}
		
		return enterprises;
	}

	private List<Enterprise> findAllEnterprises() {
		EnterpriseHibernateService enterpriseService = new EnterpriseHibernateService();
		List<Enterprise> enterprises = null;

		try {
			enterprises = enterpriseService.findAllEnterprises();
		} catch (NumberFormatException e) {
        	l.error((new StringBuilder()).append("SubjectServiceController.findAllEnterprises(): ").append(e.getMessage()));
		}

		return enterprises;
	}
	
	private void enterpriseToJson (List<Enterprise> enterprises, HttpServletResponse res) {
		Gson gson = new Gson();
		PrintWriter pw = null;
		
		try {
			pw = res.getWriter();
		} catch (IOException e) {
        	l.error((new StringBuilder()).append("SubjectServiceController.enterpriseToJson(): ").append(e.getMessage()));
		}
		
		String json = gson.toJson(enterprises);
		pw.print(json);
	}
	
	public String goPage(Model m) throws SQLException {
		return null;
	}
}