package com.example.rizki.database.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Kontak {
    @PrimaryKey(autoGenerate = true)
    public int id = 0;

    @ColumnInfo(name = "tlp")
    public String tlp;

    @ColumnInfo(name = "nama")
    public String Nama;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }
}
