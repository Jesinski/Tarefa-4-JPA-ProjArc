package com.bcopstein.ctrlcorredor_v7_CLEAN.app.useCases;

import com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos.StatisticsDTO;
import com.bcopstein.ctrlcorredor_v7_CLEAN.app.services.statisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsCheckUC {
    private StatisticsService statisticsService;

    @Autowired
    public StatisticsCheckUC(statisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public StatisticsDTO run(int distance){
        return statisticsService.calculateStatistics(distance);
    }
}
