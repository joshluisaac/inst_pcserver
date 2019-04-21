package com.avantsystems.services.business.http;

import java.util.Map;

public interface IMessageHandler {
    
    public abstract Object handleMessage(Object lookupItem, String serviceName,
            String methodName, Class<?>[] paramTypes, Object[] args, Map<String, Object> context);

}
