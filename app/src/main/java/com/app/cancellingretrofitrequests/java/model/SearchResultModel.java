
package com.app.cancellingretrofitrequests.java.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SearchResultModel {

    @SerializedName("data")
    private Data mData;
    @SerializedName("status")
    private String mStatus;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
