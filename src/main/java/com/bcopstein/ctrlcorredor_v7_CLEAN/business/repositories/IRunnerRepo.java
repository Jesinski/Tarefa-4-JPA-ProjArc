package com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Runner;

public interface IRunnerRepo {
    List<Runner> all();
    void removeAll();
    boolean register(Runner runner);
}
