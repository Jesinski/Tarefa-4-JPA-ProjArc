package com.bcopstein.ctrlcorredor_v7_CLEAN.app.useCases;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Runner;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.services.RunnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunnersListUC {
    private RunnerService runnerService;

    @Autowired
    public RunnersListUC(RunnerService runnerService) {
        this.runnerService = runnerService;
    }
    
    public List<Runner> run(){
        return runnerService.all();
    }    
}
