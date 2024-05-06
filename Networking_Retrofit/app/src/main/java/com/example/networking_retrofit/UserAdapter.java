package com.example.networking_retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends
        RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    // Kelas UserAdapter yang merupakan adaptor untuk RecyclerView
    public List<User> userList;
    // Daftar pengguna yang akan ditampilkan oleh adaptor
    public UserAdapter(List<User>userList){
        this.userList =userList;
    }
    // Konstruktor untuk membuat objek UserAdapter dengan daftar pengguna yang diberikan

    @NonNull
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Metode untuk membuat tampilan item pengguna yang baru
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent,false);
        return new UserViewHolder(view);
        // Inflasi tata letak item pengguna dari file XML menggunakan LayoutInflater
    }
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);
        // Metode untuk mengikat data pengguna ke tampilan item yang ada

    }
    public int getItemCount() {
        return userList.size();
    }
    // Metode untuk mendapatkan jumlah total item dalam daftar pengguna
    public static class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivAvatar;
        private TextView tvName, tvEmail;
        // Kelas UserViewHolder yang merepresentasikan tampilan item dalam RecyclerView
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
        }
        // Konstruktor untuk membuat objek UserViewHolder
         public void bind(User user){
             // Metode untuk mengikat data pengguna ke tampilan item
             Picasso.get().load(user.getAvatar()).into(ivAvatar);
             // Menggunakan Picasso untuk memuat gambar avatar pengguna dari URL
            tvName.setText(user.getFirst_name() + " "+ user.getLast_name());
            tvEmail.setText(user.getEmail());
             // Menetapkan nama dan email pengguna ke TextView
//            kontol amjay
        }
    }
}
