
package com.app.cancellingretrofitrequests.java.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Data {

    @SerializedName("count_in_response")
    private Long mCountInResponse;
    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("q")
    private String mQ;
    @SerializedName("spelling_alternatives")
    private SpellingAlternatives mSpellingAlternatives;
    @SerializedName("start")
    private Long mStart;
    @SerializedName("total_count")
    private Long mTotalCount;

    public Long getCountInResponse() {
        return mCountInResponse;
    }

    public void setCountInResponse(Long countInResponse) {
        mCountInResponse = countInResponse;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

    public String getQ() {
        return mQ;
    }

    public void setQ(String q) {
        mQ = q;
    }

    public SpellingAlternatives getSpellingAlternatives() {
        return mSpellingAlternatives;
    }

    public void setSpellingAlternatives(SpellingAlternatives spellingAlternatives) {
        mSpellingAlternatives = spellingAlternatives;
    }

    public Long getStart() {
        return mStart;
    }

    public void setStart(Long start) {
        mStart = start;
    }

    public Long getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Long totalCount) {
        mTotalCount = totalCount;
    }

}
