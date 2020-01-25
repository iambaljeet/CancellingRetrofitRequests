package com.app.cancellingretrofitrequests.java.model;

import androidx.annotation.Nullable;

public class GenericDataModel<T> {
    @Nullable
    public Boolean isSuccess;
    @Nullable
    public T data;
    @Nullable
    public String message;
    @Nullable
    public Boolean isLoading;

    public GenericDataModel(@Nullable Boolean isSuccess, @Nullable T data, @Nullable String message, @Nullable Boolean isLoading) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.message = message;
        this.isLoading = isLoading;
    }
}
