package com.bd.budget.controllers;

import com.bd.budget.models.Saving;
import com.bd.budget.services.SavingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SavingController {
    private SavingService savingService;

    public SavingController(SavingService savingService) {
        this.savingService = savingService;
    }

    @GetMapping("/savings")
    public List<Saving> getSavings() {
        return savingService.findAllSavings();
    }
}