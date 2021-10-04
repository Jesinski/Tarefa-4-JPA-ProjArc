package com.bcopstein.ctrlcorredor_v7_CLEAN.app.useCases;

import com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos.PerformanceDTO;
import com.bcopstein.ctrlcorredor_v7_CLEAN.app.services.statisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerformanceCheckUC {
    
    private StatisticsService statisticsService;
    
    @Autowired
    public PerformanceCheckUC(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public PerformanceDTO run(int distance,int year){
        return statisticsService.calculatePerformanceBoost(distance, year);
    }

}
    