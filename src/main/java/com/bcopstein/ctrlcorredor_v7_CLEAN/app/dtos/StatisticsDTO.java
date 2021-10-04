package com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos;

public class StatisticsDTO {
    private double avg, median, stdDev;

    public StatisticsDTO(double avg, double median, double stdDev) {
        this.avg = avg;
        this.median = median;
        this.stdDev = stdDev;
    }

    public double getMedia() {
        return avg;
    }

    public double getMedian() {
        return median;
    }

    public double getStdDev() {
        return stdDev;
    }    
}
