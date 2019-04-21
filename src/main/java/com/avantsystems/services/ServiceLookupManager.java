package com.avantsystems;

import java.util.HashMap;
import java.util.Map;
import com.profitera.util.Utilities;


public class ServiceLookupManager {
    
    private final Map<ServiceType, ServiceLookup> registryMap;
    private static ServiceLookupManager serviceLookupMgr;
    
    public ServiceLookupManager() {
        registryMap = new HashMap<>();
    }
    
    public static ServiceLookupManager getInstance() {
        if (serviceLookupMgr ==  null) {
            serviceLookupMgr = new ServiceLookupManager();
            final ServiceLookup business = new ServiceLookup(Utilities.loadOrExit("BusinessServices.properties"));
            final ServiceLookup system = new ServiceLookup(Utilities.loadOrExit("SystemServices.properties"));
            serviceLookupMgr.registryMap.put(ServiceType.BUSINESS_SERVICES, business);
            serviceLookupMgr.registryMap.put(ServiceType.SYSTEM_SERVICES, system);
        }
       return serviceLookupMgr;
    }
    
    
    public ServiceLookup getServiceLookup(final ServiceType type) {
        return registryMap.get(type);
    }

}
