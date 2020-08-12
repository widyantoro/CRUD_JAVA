package com.example.Tugas_UAS_AKB_IF3_10117113.View;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.example.Tugas_UAS_AKB_IF3_10117113.MainActivity;
import com.example.Tugas_UAS_AKB_IF3_10117113.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;


/**
 * Tanggal Pengerjaan : 11 Agustus 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class SplashActivity extends AwesomeSplash {
    @Override
    public void initSplash(ConfigSplash configSplash){
        getSupportActionBar().hide();
        //menambahkan background
        configSplash.setBackgroundColor(R.color.colorAccent);
        configSplash.setAnimCircularRevealDuration(3000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);

        //menambahkan logo
        configSplash.setLogoSplash(R.drawable.logo);
        configSplash.setAnimLogoSplashDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);

    }
    @Override
    public void animationsFinished(){
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }
}
