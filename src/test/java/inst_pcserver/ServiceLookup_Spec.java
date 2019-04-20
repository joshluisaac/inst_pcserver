package inst_pcserver;

import java.util.Arrays;
import java.util.Properties;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.avantsystems.ServiceLookup;
import com.profitera.util.Utilities;

public class ServiceLookup_Spec {



    /* dependencies */
    ServiceLookup serviceLookup;
    Properties prop;

    @Before
    public void run_once_per_test() {
        prop = Utilities.loadOrExit("BusinessServices.properties");
        serviceLookup = new ServiceLookup(prop);
    }



    // @Test
    public void loadProp() {

        // get all services
        String[] allServices = serviceLookup.getAllServiceNames();

    }

    @Test
    public void expects_failed_service_when_invalid_service_is_passed() {
        boolean result = serviceLookup.getFailedServices()
                .contains("com.avantsystems.business.services.ErrorService");
        Assert.assertThat(result, CoreMatchers.is(true));
    }



}
