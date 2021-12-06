package com.example.traveler.api;

import com.example.traveler.model.PariwisataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("wisata")
    Call<PariwisataModel> getWisata();
}
