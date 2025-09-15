package com.bd.budget.services.impl;

import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.Income;
import com.bd.budget.models.IncomeCategory;
import com.bd.budget.repositories.IncomeCategoryRepository;
import com.bd.budget.repositories.IncomeRepository;
import com.bd.budget.services.IncomeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeCategoryRepository incomeCategoryRepository;

    public IncomeServiceImpl(IncomeRepository incomeRepository, IncomeCategoryRepository incomeCategoryRepository) {
        this.incomeRepository = incomeRepository;
        this.incomeCategoryRepository = incomeCategoryRepository;
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
        System.out.println(incomeRepository.findAll());
        return incomeRepository.findAll();
    }

    @Override
    public List<IncomeCategory> findAllIncomeCategories() {
        return incomeCategoryRepository.findAll();
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

        incomeRepository.delete(income);
    }
}