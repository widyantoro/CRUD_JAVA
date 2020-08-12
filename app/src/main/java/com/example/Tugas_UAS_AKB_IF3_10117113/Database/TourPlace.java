package com.example.Tugas_UAS_AKB_IF3_10117113.Database;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Tanggal Pengerjaan : 11 Agustus 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class TourPlace implements Parcelable {
    private int id;
    private String nama;
    private String alamat;
    private String waktubuka;
    private String deskripsi;
    private String foto;
    private String lang;
    private String leng;

    public TourPlace(int id, String nama, String alamat, String waktubuka, String deskripsi, String foto, String lang, String leng) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.waktubuka = waktubuka;
        this.deskripsi = deskripsi;
        this.foto = foto;
        this.lang = lang;
        this.leng = leng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getWaktuBuka() {
        return waktubuka;
    }

    public void setWaktuBuka(String waktu) {
        this.waktubuka = waktu;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLeng() {
        return leng;
    }

    public void setLeng(String leng) {
        this.leng = leng;
    }

    public static Creator<TourPlace> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
        dest.writeString(this.waktubuka);
        dest.writeString(this.deskripsi);
        dest.writeString(this.foto);
        dest.writeString(this.lang);
        dest.writeString(this.leng);
    }

    public TourPlace(Parcel in){
        this.id = in.readInt();
        this.nama = in.readString();
        this.alamat = in.readString();
        this.waktubuka = in.readString();
        this.deskripsi = in.readString();
        this.foto = in.readString();
        this.lang = in.readString();
        this.leng = in.readString();
    }

    public TourPlace() {

    }

    public static final Creator<TourPlace> CREATOR = new Creator<TourPlace>(){

        @Override
        public TourPlace createFromParcel(Parcel source) {
            return new TourPlace(source);
        }

        @Override
        public TourPlace[] newArray(int size) {
            return new TourPlace[size];
        }
    };
}
