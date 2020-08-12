package com.example.Tugas_UAS_AKB_IF3_10117113.Database;

import android.content.Context;

/**
 * Tanggal Pengerjaan : 11 Agustus 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class ListInsert {

    private static DatabaseHelper databaseHelper;

    public ListInsert(Context context){

        databaseHelper = new DatabaseHelper(context);
  //      Log.d("insert", "inserting data");
        databaseHelper.save(new TourPlace(1, "Masjid Raya Bandung",
                "Jl. Dalem Kaum No.14, Balonggede, Kec. Regol, Kota Bandung, Jawa Barat 40251",
                "Selalu Buka",
                "Masjid Agung Bandung merupakan sebuah masjid utama di provinsi Jawa Barat, " +
                         "Masjid ini bukan hanya tempat ibadah umat muslim yang ingin beribadah, " +
                         "Tapi juga tempat rekreasi dengan adanya taman dan menaranya.",
                "https://4.bp.blogspot.com/-vTlgKRhEtYE/WzYwx_bjBvI/AAAAAAAAEWo/Z863HQ76mtw2AoCBDZSjwqAdHLGcFgRBwCLcBGAs/s640/mbandung3.png",
                "-6.921723", "107.606106"));

        databaseHelper.save(new TourPlace(2, "Jalan Braga",
                "Jalan Braga, Kota Bandung, Jawa Barat",
                "Selalu Buka",
                "Jalan ini adalah salah satu ikon terkenal di wisata Kota Bandung, " +
                         "Jalan Braga penuh dengan Nuansa Klasik Khas Eropa, " +
                         "Jalan Braga memiliki banyak tempat Nongkrong Anak Muda.",
                "https://www.nativeindonesia.com/wp-content/uploads/2018/09/Jalan-Braga-3.jpg",
                "-6.919134", "107.609782"));

        databaseHelper.save(new TourPlace(3, "Kawasan Punclut",
                "Jl. Punclut, Ciumbuleuit, Kec. Cidadap, Kabupaten Bandung Barat, Jawa Barat 40142",
                "Setiap Hari 09.00-22.00",
                "Punclut yang merupakan singkatan dari Puncak Ciumbuleuit, " +
                         "salah satu kawasan yang terletak di sebelah utara Kota Bandung, " +
                         "Wisatawan yang datang untuk berwisata dan menikmati pemandangan Kota Bandung.",
                "https://d99i6ad9lbm5v.cloudfront.net/uploads/image/file/5540/gambar-ddieuland-bandung-malam-hari.jpg",
                "-6.842117", "107.623047"));

        databaseHelper.save(new TourPlace(4, "Bukit Moko",
                "Cimenyan, Kec. Cimenyan, Bandung, Jawa Barat 40197",
                "Selalu Buka",
                "Sebagaimana namanya bukit ini adalah kawasan perbukitan yang memiliki keunggulan " +
                         "berupa pemandangan alam yang indah dari mulai hijaunya bukit sampai pemandangan " +
                         "Kota Bandung dari atas.",
                "https://dolanyok.com/wp-content/uploads//pemadangan-bukit-moko.png",
                "-6.842218", "107.676656"));

        databaseHelper.save(new TourPlace(5, "Babakan Siliwangi",
                "Jl. Siliwangi Dalam 3, Lb. Siliwangi, Kecamatan Coblong, Kota Bandung, Jawa Barat 40132",
                "Selalu Buka",
                "Baksil adalah salah satu kawasan hutan kota di Bandung. " +
                         "Lokasi Babakan Siliwangi yang tidak jauh dari pusat kota, " +
                         "terdapat berbagai wahana permainan dan cocok juga untuk spot foto bagi yang suka selfie.",
                "https://www.jalajahnusae.com/wp-content/uploads/2018/10/Forest-Walk.jpg",
                "-6.885221", "107.610100"));

    }



}
