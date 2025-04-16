package com.bd.budget.services.impl;

import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.Income;
import com.bd.budget.repositories.IncomeRepository;
import com.bd.budget.services.IncomeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public Income findById(Long incomeId) {
        return incomeRepository
                .findById(incomeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The income entry with given id does not exist: " + incomeId));
    }

    @Override
    public List<Income> findAll() {
        return incomeRepository.findAll();
    }

    @Override
    public Income add(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Income update(Long incomeId, Income updatedIncome) {
        Income income = incomeRepository
                .findById(incomeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The income entry with given id does not exist: " + incomeId));

        income.setCategory(updatedIncome.getCategory());
        income.setAmount(updatedIncome.getAmount());
        income.setNotes(updatedIncome.getNotes());
        income.setDateAdded(updatedIncome.getDateAdded());

        return incomeRepository.save(income);

    }

    @Override
    public void delete(Long incomeId) {
        Income income = incomeRepository
                .findById(incomeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The income entry with given id does not exist: " + incomeId));

        incomeRepository.deleteById(incomeId);
    }
}