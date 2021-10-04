package com.bcopstein.ctrlcorredor_v7_CLEAN.app.useCases;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Event;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventListUC {
    private EventService eventService;

    @Autowired
    public EventListUC(EventService eventService) {
        this.eventService = eventService;
    }
    
    public List<Event> run(){
        return eventService.all();
    }    
    
}
