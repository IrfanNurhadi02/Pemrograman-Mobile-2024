package com.example.networking_retrofit;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {
    @GET("api/users")
        // Metode GET untuk mendapatkan daftar pengguna dari server
    Call<UserResponse> getUsers(@Query("page") int page, @Query("per_page") int per_page);
    // Metode ini akan mengembalikan objek Call<UserResponse> yang berisi daftar pengguna
    // @Query("page") digunakan untuk menentukan halaman dari daftar pengguna yang akan diminta
}

