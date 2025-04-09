package com.example.quanlichitieu.repository;
import com.example.quanlichitieu.controller.ApiService;
import com.example.quanlichitieu.controller.RetrofitClient;
import com.example.quanlichitieu.model.IncomeCategory;
import java.util.List;
import retrofit2.Callback;

public class IncomeRepository {
    private ApiService apiService;

    public IncomeRepository() {
        apiService = RetrofitClient.getApiService();
    }

    public void getIncomeCategories(Callback<List<IncomeCategory>> callback) {
        apiService.getIncomeCategories().enqueue(callback);
    }
}




