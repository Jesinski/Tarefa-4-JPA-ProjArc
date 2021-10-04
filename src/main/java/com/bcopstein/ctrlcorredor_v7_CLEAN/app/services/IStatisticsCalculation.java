package com.bcopstein.ctrlcorredor_v7_CLEAN.app.services;

import com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos.StatisticsDTO;

public interface IStatisticsCalculation {
    public StatisticsDTO calculateStatistics(int distance);
}
