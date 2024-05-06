package com.example.networking_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
   private static final String BASE_URL = "https://reqres.in/";

   private static Retrofit retrofit = null;
    // Ketika kita mendeklarasikan variabel `retrofit` di sini, kita menginisialisasikannya dengan
    // nilai `null`.
   public static Retrofit getClient(){
       // Ini adalah metode yang akan kita panggil ketika ingin mendapatkan instance Retrofit.
       if (retrofit == null){
           // Pada awalnya, kita akan memeriksa apakah variabel `retrofit` masih `null` atau tidak.
           retrofit = new Retrofit.Builder()
                   // Jika nilai variabel `retrofit` masih `null`, artinya belum ada instance Retrofit yang dibuat sebelumnya.
                   // Oleh karena itu, kita perlu membuat instance Retrofit baru.
                   .baseUrl(BASE_URL)
                   // Di sini, kita mengatur baseUrl untuk Retrofit, yang akan menjadi dasar dari setiap permintaan ke server.
                   .addConverterFactory(GsonConverterFactory.create())
                   // Selanjutnya, kita menambahkan converter factory untuk mengkonversi data JSON menjadi objek Java menggunakan Gson.
                   .build();
           // Terakhir, kita membangun instance Retrofit dari konfigurasi yang telah ditetapkan.
           // Setelah instance Retrofit dibuat, kita menyimpannya dalam variabel `retrofit`.
       }
       return retrofit;
       // Jika kondisi `if` tidak terpenuhi, ini berarti sudah ada instance Retrofit yang ada sebelumnya.
       // Kita akan langsung mengembalikan instance Retrofit yang sudah ada.
   }
}
