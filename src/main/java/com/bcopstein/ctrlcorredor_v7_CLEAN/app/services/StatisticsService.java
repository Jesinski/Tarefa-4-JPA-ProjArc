package com.bcopstein.ctrlcorredor_v7_CLEAN.app.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos.StatisticsDTO;
import com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos.PerformanceDTO;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Event;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories.IEventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsService {
    private IEventRepo eventRepo;
    private IStatisticsCalculation statisticsCalculation;

    @Autowired
    public StatisticsService(IEventRepo eventoRepository,IStatisticsCalculation statisticsCalculation){
        this.eventRepo = eventoRepository;
        this.statisticsCalculation = statisticsCalculation;
    }

    public StatisticsDTO calculateStatistics(int distance){
        return statisticsCalculation.calculateStatistics(distance);
    }

    public PerformanceDTO calculatePerformanceBoost(int distance,int year){
        List<Event> events = eventRepo
            .all()
            .stream()
            .filter(e->e.getYear() == year)
            .collect(Collectors.toList());
        int deltaIndex = 0;
        double delta = -1.0;
        for(int i=0;i<events.size()-1;i++){
            Event e1 = events.get(i);
            Event e2 = events.get(i+1);
            double time1 = e1.getHours()*3600 + e1.getMinutes()*60.0 + e1.getSeconds();
            double time2 = e2.getHours()*3600 + e2.getMinutes()*60.0 + e2.getSeconds();
            if ((time1-time2)>delta){
                delta = time1-time2;
                deltaIndex = i;
            }
        }         
        return new PerformanceDTO(
            events.get(deltaIndex).getName(),
            events.get(deltaIndex+1).getName(),
            delta);
    }
}
