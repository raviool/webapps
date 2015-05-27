package t124003.backend.service;

import junit.framework.TestCase;
import t124003.backend.model.subject.Enterprise;

import java.util.List;

public class EnterpriseHibernateServiceTest extends TestCase {

    public void testFindEnterprisesByName() throws Exception {
        EnterpriseHibernateService enterpriseHibernateService = new EnterpriseHibernateService();
        List<Enterprise> enterpriseList = enterpriseHibernateService.findEnterprisesByName("torupood");
        assertEquals(1, enterpriseList.size());
        assertEquals("Torupood OY", enterpriseList.get(0).getFullName());
        assertEquals("Torupood", enterpriseList.get(0).getName());
    }

    public void testFindAllEnterprises() throws Exception {
        EnterpriseHibernateService enterpriseHibernateService = new EnterpriseHibernateService();
        List<Enterprise> enterpriseList = enterpriseHibernateService.findAllEnterprises();
        assertEquals(2, enterpriseList.size());
        assertEquals("Torupood OY", enterpriseList.get(1).getFullName());
        assertEquals("Torupood", enterpriseList.get(1).getName());
        assertEquals("Oy yhendatud Systeemid Ltd", enterpriseList.get(0).getFullName());
        assertEquals("Yhendatud Systeemid", enterpriseList.get(0).getName());
    }
}