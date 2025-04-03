package com.bd.budget.services.impl;

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
    public List<Saving> findAllSavings() {
        return savingRepository.findAll();
    }
}