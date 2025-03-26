package com.cnpm.QuanLiChiTieu.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Income_Categories")
@Data
public class IncomeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer incomeCategoryId;

    @Column(nullable = false, unique = true)
    private String incomeCategoryName;

    private String imageUrl;
}
