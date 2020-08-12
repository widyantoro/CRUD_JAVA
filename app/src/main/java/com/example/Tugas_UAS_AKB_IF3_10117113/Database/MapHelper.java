package com.example.Tugas_UAS_AKB_IF3_10117113.Database;

import android.database.Cursor;

import java.util.ArrayList;

/**
 * Tanggal Pengerjaan : 11 Agustus 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class MapHelper {
    public static ArrayList<TourPlace> mapCursorToArrayList(Cursor TourPlaceCursor) {
        ArrayList<TourPlace> TourPlaceList = new ArrayList<>();

        while (TourPlaceCursor.moveToNext()) {
           int id = TourPlaceCursor.getInt(TourPlaceCursor.getColumnIndexOrThrow(DatabaseHelper.MyColumns.id));
           String nama = TourPlaceCursor.getString(TourPlaceCursor.getColumnIndexOrThrow(DatabaseHelper.MyColumns.nama));
           String alamat = TourPlaceCursor.getString(TourPlaceCursor.getColumnIndexOrThrow(DatabaseHelper.MyColumns.alamat));
            String waktuBuka = TourPlaceCursor.getString(TourPlaceCursor.getColumnIndexOrThrow(DatabaseHelper.MyColumns.waktubuka));
            String deskripsi = TourPlaceCursor.getString(TourPlaceCursor.getColumnIndexOrThrow(DatabaseHelper.MyColumns.deskripsi));
            String foto = TourPlaceCursor.getString(TourPlaceCursor.getColumnIndexOrThrow(DatabaseHelper.MyColumns.foto));
            String lang = TourPlaceCursor.getString(TourPlaceCursor.getColumnIndexOrThrow(DatabaseHelper.MyColumns.lang));
            String leng = TourPlaceCursor.getString(TourPlaceCursor.getColumnIndexOrThrow(DatabaseHelper.MyColumns.leng));
            TourPlaceList.add(new TourPlace(id, nama, alamat, waktuBuka, deskripsi, foto, lang, leng));

        }
        return TourPlaceList;
    }

}
