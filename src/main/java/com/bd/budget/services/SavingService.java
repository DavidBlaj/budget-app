package com.bd.budget.services;

import com.bd.budget.models.Saving;
import com.bd.budget.models.Saving;

import java.util.List;

public interface SavingService {

    List<Saving> findAll();

    Saving findById(Long savingId);

    Saving add(Saving saving);

    Saving update(Long savingId, Saving updatedSaving);

    void delete(Long savingId);
}

