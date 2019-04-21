package com.avantsystems.services.business;

import java.util.HashMap;
import java.util.Map;
import com.avantsystems.services.IEventService;
import com.avantsystems.services.IScheduleListener;
import com.avantsystems.services.ServiceLookup;
import com.avantsystems.services.ServiceLookupManager;
import com.avantsystems.services.ServiceType;
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
       Object result = stub.handleMessage(this, "EventService", "sendEvent", new Class<?>[]{String.class, Map.class},
               new Object[]{name, arguments}, new HashMap<String, Object>());
           return (TransferObject) result;
    }

}
