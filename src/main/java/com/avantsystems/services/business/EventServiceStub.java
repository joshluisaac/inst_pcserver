package com.avantsystems.services.business;

import java.util.Map;
import com.avantsystems.ServiceLookup;
import com.avantsystems.ServiceLookupManager;
import com.avantsystems.ServiceType;
import com.avantsystems.services.IEventService;
import com.avantsystems.services.IScheduleListener;
import com.avantsystems.services.TransferObject;
import com.avantsystems.services.business.http.IMessageHandler;


public class EventServiceStub extends BusinessService implements IEventService, IScheduleListener {

    @Override
    public void invokeScheduledEvent(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public TransferObject sendEvent(String name, Map<String, Object> arguments) {
       ServiceLookup system = ServiceLookupManager.getInstance().getServiceLookup(ServiceType.SYSTEM_SERVICES);
       IMessageHandler stub = (IMessageHandler) system.getService("MessageHandler");
        return null;
    }
    
    

}
