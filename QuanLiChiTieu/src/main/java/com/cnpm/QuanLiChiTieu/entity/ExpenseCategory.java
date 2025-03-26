package com.cnpm.QuanLiChiTieu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Expense_Categories")
@Data
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseCategoryId;

    @Column(nullable = false, unique = true)
    private String expenseCategoryName;

    private String imageUrl;
}
