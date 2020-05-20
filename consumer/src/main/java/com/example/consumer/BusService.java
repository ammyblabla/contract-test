package com.example.consumer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BusService {
    @GET("{station}/{nr}")
    Call<BusDto> getBus(@Path("station") String station, @Path("nr") int nr);
}
