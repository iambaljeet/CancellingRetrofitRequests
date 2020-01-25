package com.app.cancellingretrofitrequests.java.repository;

import androidx.lifecycle.MutableLiveData;

import com.app.cancellingretrofitrequests.java.model.GenericDataModel;
import com.app.cancellingretrofitrequests.java.model.SearchResultModel;
import com.app.cancellingretrofitrequests.java.networking.ApiProvider;
import com.app.cancellingretrofitrequests.java.networking.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {
    public static ApiService
            apiService =
            new ApiProvider().createService(
                    ApiService.class);
    public static MutableLiveData<GenericDataModel<SearchResultModel>> searchResultsLiveData = new MutableLiveData<>();
    public static Call<SearchResultModel> searchResultModelCall = null;

    public static MutableLiveData<GenericDataModel<SearchResultModel>> getSearchResults(String searchQuery) {
        GenericDataModel genericDataModel =
                new GenericDataModel(
                        null,
                        null,
                        null,
                        true
                );

        searchResultsLiveData.postValue(genericDataModel);
        if (searchResultModelCall != null) {
            searchResultModelCall.cancel();
        }
        searchResultModelCall = apiService.getResult(searchQuery);
        searchResultModelCall.enqueue(new Callback<SearchResultModel>() {
            @Override
            public void onResponse(Call<SearchResultModel> call, Response<SearchResultModel> response) {
                GenericDataModel genericDataModel =
                        new GenericDataModel(
                                response.isSuccessful(),
                                response.body(),
                                response.message(),
                                false);

                searchResultsLiveData.postValue(genericDataModel);
            }

            @Override
            public void onFailure(Call<SearchResultModel> call, Throwable t) {
                if (!call.isCanceled()) {
                    GenericDataModel genericDataModel =
                            new GenericDataModel(
                                    false,
                                    null,
                                    t.getMessage(),
                                    false);

                    searchResultsLiveData.postValue(genericDataModel);
                }
            }
        });
        return searchResultsLiveData;
    }
}