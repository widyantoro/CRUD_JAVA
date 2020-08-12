package com.example.Tugas_UAS_AKB_IF3_10117113.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.NamaTabel;
import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.alamat;
import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.deskripsi;
import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.foto;
import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.id;
import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.lang;
import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.leng;
import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.nama;
import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.waktubuka;


/**
 * Tanggal Pengerjaan : 11 Agustus 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //InnerClass, untuk mengatur artibut seperti Nama Tabel, nama-nama kolom dan Query
    static abstract class MyColumns implements BaseColumns {
        //Menentukan Nama Table dan Kolom
        static final String NamaTabel = "tempatWisata";
        public static String id = "id";
        public static String nama = "nama";
        public static String alamat = "alamat";
        public static String waktubuka = "waktubuka";
        public static String deskripsi = "deskripsi";
        public static String foto = "foto";
        public static String lang = "lang";
        public static String leng = "leng";
    }

    private static final String NamaDatabse = "dma.db";
    private static final int VersiDatabase = 1;

    //Query yang digunakan untuk membuat Tabel
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+ NamaTabel+
            "("+ MyColumns.id+" TEXT PRIMARY KEY, "+ MyColumns.nama+" TEXT NOT NULL, "+ MyColumns.alamat+
            " TEXT NOT NULL, "+ MyColumns.waktubuka+" TEXT NOT NULL, "+ MyColumns.deskripsi+
            " TEXT NOT NULL, "+ MyColumns.foto+" BLOB NOT NULL, "+ MyColumns.lang+" TEXT NOT NULL, "+ MyColumns.leng+" TEXT NOT NULL)";

    //Query yang digunakan untuk mengupgrade Tabel
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+ NamaTabel;


    public void save(TourPlace tp){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(id, tp.getId());
        values.put(nama, tp.getNama());
        values.put(alamat, tp.getAlamat());
        values.put(waktubuka, tp.getWaktuBuka());
        values.put(deskripsi, tp.getDeskripsi());
        values.put(foto, tp.getFoto());
        values.put(lang, tp.getLang());
        values.put(leng, tp.getLeng());

        db.insert(NamaTabel, null, values);
        db.close();
    }

    public DatabaseHelper(Context context) {
        super(context, NamaDatabse, null, VersiDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }


}
