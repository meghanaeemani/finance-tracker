package com.megha.finance.financetracker.controller;

import com.megha.finance.financetracker.model.Expense;
import com.megha.finance.financetracker.service.ExpenseService; // Now importing the Service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService; // Switch from Repository to Service

    @GetMapping
    public List<Expense> getAll() {
        return expenseService.getAllExpenses(); // Use the service method
    }

    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense); // Use the service method
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expenseService.deleteExpense(id); // Use the service method
    }
}