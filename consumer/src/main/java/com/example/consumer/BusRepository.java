package com.example.consumer;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class BusRepository {
    public static final String API_URL = "http://localhost:8111/bus/";

    public BusDto getBus (String station, int nr) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BusService busService = retrofit.create(BusService.class);
        Call<BusDto> call = busService.getBus(station, nr);
        Response response = call.execute();
        return (BusDto) response.body();
    }

}
