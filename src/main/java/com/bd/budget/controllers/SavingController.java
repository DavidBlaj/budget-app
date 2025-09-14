package com.bd.budget.controllers;

import com.bd.budget.models.Saving;
import com.bd.budget.services.SavingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savings")
public class SavingController {
    private SavingService savingService;

    public SavingController(SavingService savingService) {
        this.savingService = savingService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Saving> findSavingById(@PathVariable("id") Long savingId) {
        Saving saving = savingService.findById(savingId);
        return ResponseEntity.ok(saving);
    }

    @GetMapping("/savings")
    public List<Saving> findAllSavings() {
        return savingService.findAll();
    }

    @PostMapping
    public ResponseEntity<Saving> addSaving(@RequestBody Saving saving) {
        Saving addedSaving = savingService.add(saving);
        return new ResponseEntity<>(addedSaving, HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<Saving> updateSaving(@PathVariable("id") Long savingId,
                                          @RequestBody Saving updatedSaving) {
        Saving saving = savingService.update(savingId, updatedSaving);
        return ResponseEntity.ok(saving);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSaving(@PathVariable("id") Long savingId) {
        savingService.delete(savingId);
        return ResponseEntity.ok("Saving entry has been successfully deleted!");
    }
}