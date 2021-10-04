package com.bcopstein.ctrlcorredor_v7_CLEAN.business.services;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Event;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories.IEventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventService {
    private IEventRepo eventRepo;

    @Autowired
    public EventService(IEventRepo eventRepo){
        this.eventRepo = eventRepo;
    } 

    public List<Event> all(){
        return eventRepo.all();
    }

    public void register(Event event){
        eventRepo.register(event);
    }
    
}
