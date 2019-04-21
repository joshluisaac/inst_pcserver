package com.avantsystems.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLookup {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceLookup.class);

    private Map<String, Service> servicesMap;
    private Properties props;
    private Set<String> failedServices = new HashSet<String>();

    public ServiceLookup(final Properties inProperties) {
        loadServies(inProperties);
    }
    
    public ServiceLookup() {
    }

    /**
     * Loads all services available in properties file.
     * 
     * @param inProperties the given properties file.
     */
    public void loadServies(final Properties inProperties) {
        servicesMap = new ConcurrentHashMap<String, Service>();
        props = inProperties;
        props.forEach((key, value) -> getService((String) key));
    }

    /**
     * 
     * Checks if a service is already loaded and persisted to {@link ServiceLookup#servicesMap},
     * otherwise it will load and return the given {@link Service}.
     * 
     * @param name
     * @return
     */
    public Service getService(final String name) {
        Service service = servicesMap.get(name);
        if (service == null) {
            final String value = props.getProperty(name);
            if (value == null) {
                return null;
            }
            try {
                servicesMap.put(name, (Service) Class.forName(value.trim()).newInstance());
                LOG.debug("Initialized {} - {}", name, value);
            } catch (Throwable e) { // NOPMD - Need to catch everything here
                failedServices.add(value);
                //LogFactory.getLog(ServiceLookup.class).fatal(e.getClass().getName(), e);
                LOG.error(e.getClass().getName(), e);
            }
        }
        return service;
    }

    /**
     * Returns all loaded/registered services in alphabetical order.
     * 
     * @return the Service names in alphabetical order
     */
    public String[] getAllServiceNames() {
        final Set<String> set = servicesMap.keySet();
        String[] array = set.toArray(new String[set.size()]);
        Arrays.sort(array);
        return array;
    }

    public void setService(String name, Service service) {
        servicesMap.put(name, service);
    }

    /**
     * Returns a {@link Set} of failed services.
     * 
     * @return failed services.
     */
    public Set<String> getFailedServices() {
        return failedServices;
    }
    
    
    /**
     * Returns a {@link Map} of successful services.
     * 
     * @return passed services.
     */
    public Map<String, Service> getPassedServices() {
        return servicesMap;
    }
    
    

}
