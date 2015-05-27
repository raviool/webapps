package t124003.backend.service;

import junit.framework.TestCase;
import t124003.backend.service.sessionmanagement.CustomUserDetails;

import java.util.HashSet;

public class BufferServiceTest extends TestCase {


    public void testMoveDocuments() throws Exception {
        BufferService bufferService = new BufferService();
        DocCatalogHibernateService docCatalogHibernateService = new DocCatalogHibernateService();
        CustomUserDetails user = new CustomUserDetails();
        HashSet<Integer> buffer = new HashSet<Integer>();
        buffer.add(1);
        buffer.add(2);
        user.setBuffer(buffer);
        assertEquals(2, user.getBuffer().size());
        bufferService.moveDocuments(user, 5, "juhan");
        assertEquals(0, user.getBuffer().size());
        Integer firstDocCatalog = docCatalogHibernateService.findDocumentCatalog(1);
        assertEquals(new Integer(5), firstDocCatalog);
        Integer secondDocCatalog = docCatalogHibernateService.findDocumentCatalog(2);
        assertEquals(new Integer(5), secondDocCatalog);
    }

    public void testEmptyBuffer() throws Exception {
        BufferService bufferService = new BufferService();
        CustomUserDetails user = new CustomUserDetails();
        HashSet<Integer> buffer = new HashSet<Integer>();
        buffer.add(1);
        buffer.add(2);
        user.setBuffer(buffer);
        assertEquals(2, user.getBuffer().size());
        bufferService.emptyBuffer(user);
        assertEquals(0, user.getBuffer().size());
    }
}