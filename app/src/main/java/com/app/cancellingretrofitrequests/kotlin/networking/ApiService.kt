package com.app.cancellingretrofitrequests.kotlin.networking

import com.app.cancellingretrofitrequests.kotlin.model.SearchResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    companion object {
        val BASE_URL: String = "https://demo.dataverse.org/api/"
    }

    @GET("search")
    suspend fun getResult(
            @Query("q") query: String?): Response<SearchResultModel?>
}