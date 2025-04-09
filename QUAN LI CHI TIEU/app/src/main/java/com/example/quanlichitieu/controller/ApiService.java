package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.model.IncomeCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/income-categories")  // Cập nhật API của bạn
    Call<List<IncomeCategory>> getIncomeCategories();
}
