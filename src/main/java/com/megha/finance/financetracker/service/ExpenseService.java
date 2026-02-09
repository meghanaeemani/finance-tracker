package com.megha.finance.financetracker.service;

import com.megha.finance.financetracker.model.Expense;
import com.megha.finance.financetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Tells Spring this is the "Brain" (Service Layer)
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense saveExpense(Expense expense) {
        // Here you can add logic, like "Don't allow negative amounts"
        if (expense.getAmount() < 0) {
            throw new RuntimeException("Amount cannot be negative!");
        }
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}