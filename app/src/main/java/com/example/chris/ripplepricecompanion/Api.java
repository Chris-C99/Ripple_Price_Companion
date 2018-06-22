package com.example.chris.ripplepricecompanion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chris on 1/10/18.
 */

public interface Api {

    String BASE_URL = "https://api.coinmarketcap.com/v1/ticker/";

    @GET("ripple")
    Call<List<contents>> getContents();


}
