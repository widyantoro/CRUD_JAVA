package com.example.Tugas_UAS_AKB_IF3_10117113.View;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.Tugas_UAS_AKB_IF3_10117113.Database.AdapterTourPlace;
import com.example.Tugas_UAS_AKB_IF3_10117113.Database.MapHelper;
import com.example.Tugas_UAS_AKB_IF3_10117113.Database.TourPlace;
import com.example.Tugas_UAS_AKB_IF3_10117113.Database.TourPlaceHelper;
import com.example.Tugas_UAS_AKB_IF3_10117113.R;
import com.google.android.material.snackbar.Snackbar;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Tanggal Pengerjaan : 11 Agustus 2020
 * NIM : 10117113
 * Nama : Eka Widyantoro
 * Kelas : IF-3
 */

public class ListTourPlaceActivity  extends Fragment implements LoadTourPlaceCallback{

    private ProgressBar progressBar;
    private RecyclerView rvNotes;
    private AdapterTourPlace adapter;
    private TourPlaceHelper tpHelper;
    private static final String EXTRA_STATE = "EXTRA_STATE";

//    private ImageView fabAdd;

    public ListTourPlaceActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.list_tour, container, false);

        progressBar = view.findViewById(R.id.progressbar);
        rvNotes = view.findViewById(R.id.rv_notes);
        rvNotes.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvNotes.setHasFixedSize(true);
        adapter = new AdapterTourPlace(getActivity());
        rvNotes.setAdapter(adapter);

//        }
        tpHelper = TourPlaceHelper.getInstance(getActivity());
        tpHelper.open();

        if (savedInstanceState == null) {
            new LoadNotesAsync(tpHelper, this).execute();
        } else {
            ArrayList<TourPlace> list = savedInstanceState.getParcelableArrayList(EXTRA_STATE);
            if (list != null) {
                adapter.setListNotes(list);
            }
        }


        return view;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_STATE, adapter.getListNotes());
    }


    @Override
    public void preExecute() {
        new Runnable(){
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        };
    }

    @Override
    public void postExecute(ArrayList<TourPlace> notes) {
        progressBar.setVisibility(View.INVISIBLE);
        if (notes.size() > 0) {
            adapter.setListNotes(notes);
        } else {
            adapter.setListNotes(new ArrayList<TourPlace>());
            showSnackbarMessage("Tidak ada data saat ini");
        }
    }

    private static class LoadNotesAsync extends AsyncTask<Void, Void, ArrayList<TourPlace>> {
        private final WeakReference<TourPlaceHelper> weakNoteHelper;
        private final WeakReference<LoadTourPlaceCallback> weakCallback;

        private LoadNotesAsync(TourPlaceHelper noteHelper, LoadTourPlaceCallback callback) {
            weakNoteHelper = new WeakReference<>(noteHelper);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            weakCallback.get().preExecute();
        }

        @Override
        protected ArrayList<TourPlace> doInBackground(Void... voids) {
            Cursor dataCursor = weakNoteHelper.get().queryAll();
            return MapHelper.mapCursorToArrayList(dataCursor);
        }

        @Override
        protected void onPostExecute(ArrayList<TourPlace> notes) {
            super.onPostExecute(notes);
            weakCallback.get().postExecute(notes);
        }
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        tpHelper.close();
    }

    private void showSnackbarMessage(String message) {
        Snackbar.make(rvNotes, message, Snackbar.LENGTH_SHORT).show();
    }
}

interface LoadTourPlaceCallback{
    void preExecute();
    void postExecute(ArrayList<TourPlace> notes);
}
