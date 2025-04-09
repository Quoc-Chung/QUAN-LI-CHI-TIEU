package com.example.quanlichitieu;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlichitieu.model.IncomeCategory;
import com.example.quanlichitieu.repository.IncomeRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private IncomeRepository incomeRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.caidat);
        incomeRepository = new IncomeRepository();
        loadIncomeCategories();
    }

    private void loadIncomeCategories() {
        incomeRepository.getIncomeCategories(new Callback<List<IncomeCategory>>() {
            @Override
            public void onResponse(Call<List<IncomeCategory>> call, Response<List<IncomeCategory>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<IncomeCategory> categories = response.body();
                    for (IncomeCategory category : categories) {
                        Toast.makeText(MainActivity.this, "Category: " + category.incomeCategoryName(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<IncomeCategory>> call, Throwable t) {
                Log.e("MainActivity", "Error fetching data", t);
            }
        });
    }
}