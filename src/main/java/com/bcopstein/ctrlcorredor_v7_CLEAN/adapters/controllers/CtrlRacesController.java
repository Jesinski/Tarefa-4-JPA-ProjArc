package com.bcopstein.ctrlcorredor_v7_CLEAN.adapters.controllers;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.app.useCases.*;
import com.bcopstein.ctrlcorredor_v7_CLEAN.app.dtos.*;
import com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlRaces")
public class CtrlRacesController {
    private RunnersListUC runnerListUC;
    private RunnersRegisterUC runnerRegisterUC;
    private EventListUC eventListUC;
    private EventRegisterUC eventRegisterUC;
    private StatisticsCheckUC statisticsCheckUC;
    private PerformanceCheckUC performanceCheckUC;

    @Autowired
    public CtrlRacesController(RunnersListUC runnerListUC, runnerRegister runnerRegisterUC,
            EventListUC eventListUC, EventRegisterUC eventRegisterUC,
            StatisticsCheckUC statisticsCheckUC, PerformanceCheckUC performanceCheckUC) {
        this.runnerListUC = runnerListUC;
        this.runnerRegisterUC = runnerRegisterUC;
        this.eventListUC = eventListUC;
        this.eventRegisterUC = eventRegisterUC;
        this.statisticsCheckUC = statisticsCheckUC;
        this.performanceCheckUC = performanceCheckUC;
    }

    @GetMapping("/runner")
    @CrossOrigin(origins = "*")
    public List<Runner> consultaCorredor() {
        return runnerListUC.run();
    }

    @PostMapping("/runner")
    @CrossOrigin(origins = "*")
    public boolean registerRunner(@RequestBody final Runner runner) {
        runnerRegisterUC.run(runner);
        return true;
    }

    @GetMapping("/events")
    @CrossOrigin(origins = "*")
    public List<Event> listEvents() {
        return eventListUC.run();
    }

    @PostMapping("/events") // event addition to a single runner
    @CrossOrigin(origins = "*")
    public boolean informEvent(@RequestBody final Event event) {
        eventRegisterUC.run(event);
        return true;
    }

    @GetMapping("/stats")
    @CrossOrigin(origins = "*")
    public StatisticsDTO stats(@RequestParam final Integer distance) {
        return statisticsCheckUC.run(distance);
    }

    @GetMapping("/performanceBoost")
    @CrossOrigin(origins = "*")
    public PerformanceDTO performanceBoost(@RequestParam final Integer distance, @RequestParam final Integer year) {
        return performanceCheckUC.run(distance, year);
    }
}
