package com.example.quanlichitieu.api;

import com.example.quanlichitieu.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserAPI{

    // Lấy danh sách tất cả người dùng
    @GET("api/users")
    Call<List<User>> getAllUsers();

    // Lấy thông tin 1 user theo ID
    @GET("api/users/{id}")
    Call<User> getUserById(@Path("id") int id);
}
