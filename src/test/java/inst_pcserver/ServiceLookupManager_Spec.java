package inst_pcserver;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import com.avantsystems.services.ServiceLookup;
import com.avantsystems.services.ServiceLookupManager;
import com.avantsystems.services.ServiceType;
import com.avantsystems.services.business.EmailService;
import com.avantsystems.system.services.SqlMapReadWriteProvider;

public class ServiceLookupManager_Spec {
    
    @Test
    public void given_business_services_i_expect_EmailService() {
        ServiceLookupManager serviceLookupManager =   ServiceLookupManager.getInstance();
        ServiceLookup serviceLookup = serviceLookupManager.getServiceLookup(ServiceType.BUSINESS_SERVICES);
        Assert.assertThat(serviceLookup.getPassedServices().get("EmailService"), CoreMatchers.is(CoreMatchers.instanceOf(EmailService.class)));
    }
    
    @Test
    public void given_system_services_i_expect_SqlMapReadWriteProvider() {
        ServiceLookupManager serviceLookupManager =   ServiceLookupManager.getInstance();
        ServiceLookup serviceLookup = serviceLookupManager.getServiceLookup(ServiceType.SYSTEM_SERVICES);
        Assert.assertThat(serviceLookup.getPassedServices().get("ReadWriteProvider"), CoreMatchers.is(CoreMatchers.instanceOf(SqlMapReadWriteProvider.class)));
    }


}
