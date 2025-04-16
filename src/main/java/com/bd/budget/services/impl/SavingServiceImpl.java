package com.bd.budget.services.impl;

import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.Saving;
import com.bd.budget.repositories.SavingRepository;
import com.bd.budget.services.SavingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingServiceImpl implements SavingService {
    private SavingRepository savingRepository;

    public SavingServiceImpl(SavingRepository savingRepository) {
        this.savingRepository = savingRepository;
    }

    @Override
    public Saving findById(Long savingId) {
        return savingRepository
                .findById(savingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The saving with given id does not exist: " + savingId));
    }

    @Override
    public List<Saving> findAll() {
        return savingRepository.findAll();
    }

    @Override
    public Saving add(Saving saving) {
        return savingRepository.save(saving);
    }

    @Override
    public Saving update(Long savingId, Saving updatedSaving) {
        Saving saving = savingRepository
                .findById(savingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The saving with given id does not exist: " + savingId));
        saving.setCategory(updatedSaving.getCategory());
        saving.setAmount(updatedSaving.getAmount());
        saving.setDateAdded(updatedSaving.getDateAdded());

        return savingRepository.save(saving);
    }

    @Override
    public void delete(Long savingId) {
        Saving saving = savingRepository
                .findById(savingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The saving with given id does not exist: " + savingId));
        savingRepository.deleteById(savingId);
    }

}