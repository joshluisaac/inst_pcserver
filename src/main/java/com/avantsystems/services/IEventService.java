package com.avantsystems.services;

import java.util.Map;


public interface IEventService {
    public TransferObject sendEvent(String name, Map<String, Object> arguments);
}
