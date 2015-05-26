package t124003.backend.service;

import org.springframework.stereotype.Service;
import t124003.backend.service.sessionmanagement.CustomUserDetails;

import java.util.HashSet;

/**
 * Created by Raviool on 26.05.2015.
 */


@Service("bufferService")
public class BufferService {

    public void moveDocuments(CustomUserDetails user, int catalog, String username) {
        HashSet<Integer> buffer = user.getBuffer();
        DocCatalogHibernateService docCatalogHibernateService = new DocCatalogHibernateService();
        for (Integer i: buffer) {
            docCatalogHibernateService.moveDocToCatalog(i, catalog, username);
        }
        user.setBuffer(new HashSet<Integer>());
    }

    public void emptyBuffer(CustomUserDetails user) {
        HashSet<Integer> buffer = user.getBuffer();
        System.out.println("1" + buffer);
        user.setBuffer(new HashSet<Integer>());
        buffer = user.getBuffer();
        System.out.println("2" + buffer);
    }
}
