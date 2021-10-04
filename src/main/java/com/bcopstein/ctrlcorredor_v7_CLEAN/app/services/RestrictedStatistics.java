package com.bcopstein.ctrlcorredor_v7_CLEAN.app.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos.StatisticsDTO;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Event;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories.IEventRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class RestrictedStatistics implements IStatisticsCalculation {
    private IEventRepo eventRepo;

    @Autowired
    public RestrictedStatistics(IEventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public StatisticsDTO calculateStatistics(int distance) {
        // all events from the given distance
        List<Event> events = eventRepo.all()
                                    .stream()
                                    .filter(e -> e.getDistance() == distance)
                                    .collect(Collectors.toList());
        // ordered values in a stream
        List<Double> values = events.stream()
                .map(e -> e.getHours() * 60 * 60 + e.getMinutes() * 60.0 + e.getSeconds())
                .sorted()
                .collect(Collectors.toList());
        if (events.size() >= 3){
            events.remove(0);
            events.remove(events.size()-1);
        }
        // avg
        double avg = values.stream()
                        .mapToDouble(v -> v)
                        .average()
                        .orElse(Double.NaN);
        // median
        Double median = Double.NaN;
        if (values.size() > 0) {
            median = ((values.size() % 2 == 0)
                    ? (values.get(values.size() / 2 - 1)) + (values.get(values.size() / 2)) / 2.0
                    : (values.get(values.size() / 2)));
        }
        // std deviation
        double variance;
        double stdDev = Double.NaN;
        if (median != Double.NaN) {
            variance = values.stream()
                            .mapToDouble(v -> v - avg)
                            .map(v -> v * v)
                            .average()
                            .getAsDouble();
            stdDev = Math.sqrt(variance);
        }
        return new StatisticsDTO(avg+500, median, stdDev);
    }
}
