package com.bcopstein.ctrlcorredor_v7_CLEAN.app.useCases;

import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.Runner;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.services.RunnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunnersRegisterUC {
    private RunnerService runnerService;

    @Autowired
    public RunnersRegisterUC(RunnerService runnerService) {
        this.runnerService = runnerService;
    }
    
    public void run(Runner runner){
        runnerService.registerRunner(runner);
    }
    
}
