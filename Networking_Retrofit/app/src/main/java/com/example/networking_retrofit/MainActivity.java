package com.example.networking_retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = ApiConfig.getClient().create(ApiService.class);
        // Inisialisasi ApiService untuk melakukan panggilan jaringan menggunakan Retrofit
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Menghubungkan RecyclerView dari layout dengan objek RecyclerView dalam kode

        Call<UserResponse>call = apiService.getUsers(2, 10);
        // Membuat panggilan jaringan untuk mendapatkan daftar pengguna dari server
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()){
                    // Jika respons dari server berhasil diterima
                    // Mendapatkan daftar pengguna dari respons
                    List<User> users = response.body().getData();
                    // Membuat adapter untuk RecyclerView dengan daftar pengguna yang diterima
                    userAdapter = new UserAdapter(users);
                    // Menetapkan adapter ke RecyclerView untuk menampilkan daftar pengguna
                    recyclerView.setAdapter(userAdapter);

                }else {
                    // Jika respons dari server tidak berhasil
                    // Meng-handle kasus ketika respons tidak berhasil (opsional)
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "jeljar", Toast.LENGTH_SHORT).show();

            }
        });

    }
}