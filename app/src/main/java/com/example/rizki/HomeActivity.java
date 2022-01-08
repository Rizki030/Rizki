package com.example.rizki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rizki.KontakAdapter;
import com.example.rizki.database.AppDatabase;
import com.example.rizki.database.entitas.Kontak;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvKontak;
    Button btnLogout;
    Button btnTambah;
    AppDatabase database;
    KontakAdapter kontakAdapter;
    List<Kontak> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final SPManager spManager = new SPManager(this);

        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                spManager.saveIsLogin(false);
                finishAffinity();
                startActivity(i);
            }
        });

        rvKontak = findViewById(R.id.rvKontak);
        btnTambah = findViewById(R.id.btnTambah);
        database = AppDatabase.getInstance(getApplicationContext());
        list = new ArrayList<>();
        list.clear();
        list.addAll(database.kontakDao().getAll());
        kontakAdapter = new KontakAdapter(list, getApplicationContext());
        //kontakAdapter = new KontakAdapter(database.kontakDao().getAll(), getApplicationContext());

        rvKontak.setHasFixedSize(true);
        rvKontak.setLayoutManager(new LinearLayoutManager(this));
        rvKontak.setAdapter(kontakAdapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, TambahActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        list.clear();
        list.addAll(database.kontakDao().getAll());
        kontakAdapter.notifyDataSetChanged();
    }
}