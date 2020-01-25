package com.app.cancellingretrofitrequests.kotlin.repository

import androidx.lifecycle.MutableLiveData
import com.app.cancellingretrofitrequests.kotlin.model.GenericDataModel
import com.app.cancellingretrofitrequests.kotlin.model.SearchResultModel
import com.app.cancellingretrofitrequests.kotlin.networking.ApiProvider
import com.app.cancellingretrofitrequests.kotlin.networking.ApiService

object DataRepository {
    var apiService: ApiService? = null
    var searchResultsLiveData: MutableLiveData<GenericDataModel<SearchResultModel>?> = MutableLiveData()

    init {
        apiService =
            ApiProvider.createService(
                ApiService::class.java
            )
    }

    suspend fun getSearchResults(searchQuery: String?) {
        val genericDataModelLoading =
            GenericDataModel(
                null,
                SearchResultModel(
                    null,
                    null
                ),
                null,
                true
            )
        searchResultsLiveData.postValue(genericDataModelLoading)
        val result = apiService?.getResult(searchQuery)
        val genericDataModel =
            GenericDataModel(
                result?.isSuccessful,
                result?.body(),
                result?.message(),
                false
            )
        searchResultsLiveData.postValue(genericDataModel)
    }
}