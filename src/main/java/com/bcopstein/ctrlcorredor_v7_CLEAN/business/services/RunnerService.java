package com.bcopstein.ctrlcorredor_v7_CLEAN.business.services;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Runner;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.repositories.IRunnerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunnerService {
    public IRunnerRepo runnerRepo;

    @Autowired
    public RunnerService(IRunnerRepo runnerRepo){
        this.runnerRepo = runnerRepo;
    }

    public List<Runner> all(){
        return runnerRepo.all();
    }

    public void registerRunner(Runner runner){
        runnerRepo.removeAll();
        runnerRepo.register(runner);
    }
    
}
