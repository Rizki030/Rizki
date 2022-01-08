package com.example.rizki.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.rizki.database.entitas.Kontak;

import java.util.List;

@Dao
public interface KontakDao {
    @Query("SELECT * FROM kontak")
    List<Kontak> getAll();

    @Insert
    void insertAll(Kontak... kontaks);
}
