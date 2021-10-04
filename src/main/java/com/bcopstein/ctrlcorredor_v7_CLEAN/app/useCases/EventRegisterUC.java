package com.bcopstein.ctrlcorredor_v7_CLEAN.app.useCases;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Event;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventRegisterUC {
    private EventService eventService;

    @Autowired
    public EventRegisterUC(EventService eventService) {
        this.eventService = eventService;
    }
    
    public void run(Event event){
        eventService.register(event);
    }    
}
