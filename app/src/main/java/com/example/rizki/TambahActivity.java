package com.example.rizki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rizki.database.AppDatabase;
import com.example.rizki.database.entitas.Kontak;

public class TambahActivity extends AppCompatActivity {

    EditText etNama, etNomor;
    Button btnSimpan;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.etNama);
        etNomor = findViewById(R.id.etNomor);
        btnSimpan = findViewById(R.id.btnSimpan);
        database = AppDatabase.getInstance(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TabahData();
            }
        });
    }

    private void TabahData() {
        if (!etNama.getText().toString().isEmpty() && !etNomor.getText().toString().isEmpty()) {

            Kontak kontak = new Kontak();
            kontak.Nama = etNama.getText().toString();
            kontak.tlp = etNomor.getText().toString();
            database.kontakDao().insertAll(kontak);

            startActivity(new Intent(TambahActivity.this, HomeActivity.class));
            Toast.makeText(this, "Kontak Baru Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }
}