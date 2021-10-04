package com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos;

public class PerformanceDTO {
    private String race1;
    private String race2;
    private Double reduction;

    public PerformanceDTO(String race1, String race2, Double reduction) {
        this.race1 = race1;
        this.race2 = race2;
        this.reduction = reduction;
    }

    public String getRace1() {
        return race1;
    }

    public String getRace2() {
        return race2;
    }

    public Double getReduction() {
        return reduction;
    }
}
