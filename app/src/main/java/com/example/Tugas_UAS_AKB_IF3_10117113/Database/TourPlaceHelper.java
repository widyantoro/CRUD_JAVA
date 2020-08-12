package com.example.Tugas_UAS_AKB_IF3_10117113.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.Tugas_UAS_AKB_IF3_10117113.Database.DatabaseHelper.MyColumns.id;

/**
 * Tanggal Pengerjaan : 11 Agustus 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class TourPlaceHelper {
    private static final String DATABASE_TABLE = "tempatWisata";
    private static DatabaseHelper databaseHelper;
    private static TourPlaceHelper INSTANCE;
    private static SQLiteDatabase db;
    private static ListInsert li;

    private TourPlaceHelper(Context context){

        databaseHelper = new DatabaseHelper(context);

         li = new ListInsert(context);

    }

    public static TourPlaceHelper getInstance(Context context){
        if (INSTANCE == null){
            synchronized (SQLiteOpenHelper.class){
                if (INSTANCE == null){
                    INSTANCE = new TourPlaceHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        db = databaseHelper.getWritableDatabase();
    }

    public void close(){
        databaseHelper.close();

        if (db.isOpen()){
            db.close();
        }
    }

    public Cursor queryAll(){
        return db.query(DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                 id +" Desc");

    }

    public Cursor queryById(String id){
        return db.query(
                DATABASE_TABLE,
                null,
                id + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null);
    }


}
