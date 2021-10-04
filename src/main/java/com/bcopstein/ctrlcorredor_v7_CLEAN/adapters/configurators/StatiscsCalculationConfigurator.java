package com.bcopstein.ctrlcorredor_v7_CLEAN.adapters.configurators;

import com.bcopstein.ctrlcorredor_v7_CLEAN.app.services.*;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories.IEventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatiscsCalculationConfigurator {
    private IEventRepo eventRepo;

    @Autowired
    public StatiscsCalculationConfigurator(IEventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Bean
    @ConditionalOnProperty(name = "calculation.statistics", havingValue = "original", matchIfMissing = true)
    public IStatisticsCalculation classicRule() {
        return new UsualStatistics(eventRepo);
    }

    @Bean
    @ConditionalOnProperty(name = "calculation.statistics", havingValue = "restricted")
    public IStatisticsCalculation restrictedRule() {
        return new RestrictedStatistics(eventRepo);
    }
}
