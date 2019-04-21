package com.avantsystems;

import java.util.Properties;

public class ServiceEngine {
	
	public static final String SERVER_CONFIG = "server.properties";
	private static String[] propertyFilePaths = new String[] {SERVER_CONFIG};
	private static Properties config;
	
	private ServiceEngine(String[] propFilePaths) {
		
	    if (propFilePaths != null && propFilePaths.length > 0) {
	        propertyFilePaths = propFilePaths;
	      }
	    config = loadAllProperties();
	    
	    final ServiceLookupManager serviceLookupManager = ServiceLookupManager.getInstance();
	    final ServiceLookup business = serviceLookupManager.getServiceLookup(ServiceType.BUSINESS_SERVICES);
	    exitOnWebServerServiceFailure(business);
	    
	    
		
	}
	
	private static Properties loadAllProperties() { return null;}
	
	
	public void exitOnWebServerServiceFailure(ServiceLookup business) {
	    if (business.getFailedServices().contains("com.avantsystems.services.business.WebServerService"))
	        throw new IllegalArgumentException("Web server startup failed, check logs for configuration error details");
	}

}
