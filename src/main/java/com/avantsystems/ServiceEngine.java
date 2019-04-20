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
	    
	    
		
	}
	
	private static Properties loadAllProperties() { return null;}

}
