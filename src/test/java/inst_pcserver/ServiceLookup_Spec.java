package inst_pcserver;

import java.util.Arrays;
import java.util.Properties;

import org.junit.Test;

import com.avantsystems.ServiceLookup;
import com.profitera.util.Utilities;

public class ServiceLookup_Spec {
	
	@Test
	public void loadProp() {
		Properties prop = Utilities.loadOrExit("BusinessServices.properties");
		
		ServiceLookup serviceLookup  = new ServiceLookup(prop);
		
		//get all services
		String[] allServices = serviceLookup.getAllServiceNames();

		serviceLookup.getFailedServices();
		
		//serviceLookup.getService(name);
	}

}
