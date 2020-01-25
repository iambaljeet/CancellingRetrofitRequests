
package com.app.cancellingretrofitrequests.java.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Checksum {

    @SerializedName("type")
    private String mType;
    @SerializedName("value")
    private String mValue;

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
