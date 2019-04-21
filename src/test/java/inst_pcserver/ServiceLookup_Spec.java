package inst_pcserver;


import java.util.Properties;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.avantsystems.ServiceLookup;
import com.avantsystems.services.business.BatchProcessService;
import com.avantsystems.services.business.EmailService;
import com.profitera.util.Utilities;

public class ServiceLookup_Spec {

    /* dependencies */
    private static ServiceLookup serviceLookup;
    private static Properties prop;
    
    @BeforeClass
    public static void runOnce() {
        prop = Utilities.loadOrExit("BusinessServices.properties");
        serviceLookup = new ServiceLookup(prop);
    }
    
    
    @Test
    public void expects_passed_services_when_business_services_is_given() {
        boolean result  = false;
        if (serviceLookup.getPassedServices().get("BatchProcessService") instanceof BatchProcessService) result = true;
        if (serviceLookup.getPassedServices().get("EmailService") instanceof EmailService) result = true;
        Assert.assertThat(result, CoreMatchers.is(true));
    }

    @Test
    public void expects_failed_service_when_invalid_business_service_is_given() {
        boolean result = serviceLookup.getFailedServices()
                .contains("com.avantsystems.services.business.ErrorService");
        Assert.assertThat(result, CoreMatchers.is(true));
    }



}
