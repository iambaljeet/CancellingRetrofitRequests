package com.app.cancellingretrofitrequests.java.networking;


import com.app.cancellingretrofitrequests.java.model.SearchResultModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    public static String BASE_URL = "https://demo.dataverse.org/api/";

    @GET("search")
    Call<SearchResultModel> getResult(@Query("q") String query);
}
