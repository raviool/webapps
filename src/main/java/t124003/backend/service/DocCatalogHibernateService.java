package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import t124003.backend.model.document.DocCatalog;

import java.util.List;

/**
 * Created by Raviool on 22.05.2015.
 */

@Service("DocCatalogHibernateService")
public class DocCatalogHibernateService {

    public List<DocCatalog> findAllCatalogs() {
        List<DocCatalog> docCatalogs = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocCatalog");
            docCatalogs = q.list();
        } finally {
            session.close();
        }
        return docCatalogs;
    }

    public List<DocCatalog> findNthLevelCatalogs(int level) {
        List<DocCatalog> docCatalogs = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocCatalog WHERE level=:level");
            q.setInteger("level", level);
            docCatalogs = q.list();
        } finally {
            session.close();
        }
        return docCatalogs;
    }
}
