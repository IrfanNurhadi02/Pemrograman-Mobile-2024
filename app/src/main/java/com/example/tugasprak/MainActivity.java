package com.example.tugasprak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tugasprak.PostData;
import com.example.tugasprak.PostModel;
import com.example.tugasprak.UserModel;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ImageView homeIcon, addIcon, personIcon, searchIcon;
    private FragmentManager fm = getSupportFragmentManager();
    private TextView menuTitleTv;
    private final Deque<PostModel> postModels = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        setData();
        PostData.postModels = postModels;

        HomeFragment homeFragment = new HomeFragment();
        SearchUserFragment searchUserFragment = new SearchUserFragment();
        AddPostFragment addFragment = new AddPostFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        Fragment fragment1 = fm.findFragmentByTag(HomeFragment.class.getSimpleName());
        Fragment fragment2 = fm.findFragmentByTag(SearchUserFragment.class.getSimpleName());
        Fragment fragment3 = fm.findFragmentByTag(AddPostFragment.class.getSimpleName());
        Fragment fragment4 = fm.findFragmentByTag(ProfileFragment.class.getSimpleName());

        if (!(fragment1 instanceof HomeFragment))
            fm.beginTransaction().add(R.id.fragmentContainer, new HomeFragment(), HomeFragment.class.getSimpleName())
                    .commit();

        homeIcon.setOnClickListener(v -> selectFragment(fragment1, homeFragment, "Selamat"));
        searchIcon.setOnClickListener(v -> selectFragment(fragment2, searchUserFragment, "Search User"));
        addIcon.setOnClickListener(v -> selectFragment(fragment3, addFragment, "Add Post"));
        personIcon.setOnClickListener(v -> selectFragment(fragment4, profileFragment, "Profile"));
    }

    private void selectFragment(Fragment fr, Fragment newFragment, String title) {
        menuTitleTv.setText(title);
        if (!(fr instanceof HomeFragment))
            fm.beginTransaction().replace(R.id.fragmentContainer, newFragment, HomeFragment.class.getSimpleName())
                    .commit();
    }

    void setView() {
        homeIcon = findViewById(R.id.homeIcon);
        addIcon = findViewById(R.id.addIcon);
        personIcon = findViewById(R.id.personIcon);
        searchIcon = findViewById(R.id.searchIcon);
        menuTitleTv = findViewById(R.id.menuTitleTv);
    }

    private void setData() {
        UserModel user1 = new UserModel("Maguire", "Harry Maguire", R.drawable.maguire);
        Uri uri1 = Uri.parse("android.resource://com.example.tugasprak/drawable/garnacho_salto");
        postModels.add(new PostModel(user1, uri1, "What a Goal"));

        UserModel user2 = new UserModel("Bruno", "Bruno Fernandes", R.drawable.brunof);
        Uri uri2 = Uri.parse("android.resource://com.example.tugasprak/drawable/manutdfa");
        postModels.add(new PostModel(user2, uri2, "Road To Wembley"));

        UserModel user3 = new UserModel("Bellingham", "Jude Bellingham", R.drawable.bellingham);
        Uri uri3 = Uri.parse("android.resource://com.example.tugasprak/drawable/jude");
        postModels.add(new PostModel(user3, uri3, "City??? "));

        UserModel user4 = new UserModel("Harry Kane", "Kane", R.drawable.harry_kane);
        Uri uri4 = Uri.parse("android.resource://com.example.tugasprak/drawable/harry_kane");
        postModels.add(new PostModel(user4, uri4, "I need Trophy"));

        /*UserModel user5 = new UserModel("Messi", "Lionel Messi", R.drawable.messi);
        Uri uri5 = Uri.parse("android.resource://com.example.t6/drawable/messi");
        postModels.add(new PostModel(user5, uri5, "Kabooor, mamaah aku takuuut"));*/
    }
}