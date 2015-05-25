package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.subject.Person;

import java.util.List;

@Service("personHibernateService")
public class PersonHibernateService {

    public PersonHibernateService() {};

	@SuppressWarnings("unchecked")
	public List<Person> findPersonsByName(String name) {
		List <Person> persons = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM Person as p WHERE UPPER(p.lastName) LIKE UPPER(:name)");
            q.setString("name", "%" + name + "%");
            persons = q.list();
        } finally {
            session.close();
        }
        return persons;
	}

	@SuppressWarnings("unchecked")
	public List<Person> findAllPersons() {
		List <Person> persons = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM Person");
            persons = q.list();
        } finally {
            session.close();
        }
        return persons;
	}
}
