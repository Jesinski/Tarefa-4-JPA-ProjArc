package com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Event;

public interface IEventRepo {
    List<Event> all();
    boolean register(Event event);
}
