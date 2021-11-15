package com.example.traveler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.traveler.api.ApiService;
import com.example.traveler.model.PariwisataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabFragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private final String TAG="MainActivity";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private SearchView searchView;
    private PariwisataAdapter mainAdapter;
    private List<PariwisataModel.Wisata> wisata=new ArrayList();

    public TabFragment1() {
        // Required empty public constructor
    }

    public static TabFragment1 newInstance(String param1, String param2) {
        TabFragment1 fragment = new TabFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);
        setupView(view);
        setupRecyclerView();
        getDataFromApi();
        return view;
    }

    private void setupView(View view){
        recyclerView=(RecyclerView) view.findViewById(R.id.recycler_view);
        progressBar=(ProgressBar) view.findViewById(R.id.progress_bar);
        searchView=(SearchView) view.findViewById(R.id.search_view);
    }

    private void setupRecyclerView(){
        mainAdapter=new PariwisataAdapter(this, wisata);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainAdapter);
    }

    private void getDataFromApi(){
        progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getData()
                .enqueue(new Callback<PariwisataModel>() {
                    @Override
                    public void onResponse(Call<PariwisataModel> call, Response<PariwisataModel> response) {
                        if (response.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            List<PariwisataModel.Wisata> wisata = response.body().getWisata();
                            Log.d(TAG, wisata.toString());
                            mainAdapter.setData(wisata);
                        }

                    }

                    @Override
                    public void onFailure(Call<PariwisataModel> call, Throwable t) {
                        Log.d(TAG, t.toString());
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}