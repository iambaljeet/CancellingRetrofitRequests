package com.app.cancellingretrofitrequests.java.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;

import com.app.cancellingretrofitrequests.R;
import com.app.cancellingretrofitrequests.java.model.GenericDataModel;
import com.app.cancellingretrofitrequests.java.model.SearchResultModel;
import com.app.cancellingretrofitrequests.java.repository.DataRepository;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText mSearchEditText;
    private AppCompatTextView mResultTextView;
    private ProgressBar mProgressLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSearchEditText = findViewById(R.id.searchEditText);
        mResultTextView = findViewById(R.id.resultTextView);
        mProgressLoading = findViewById(R.id.progressLoading);

        mSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                startSearching(s.toString());
            }
        });
    }

    private void startSearching(String searchQuery) {
        DataRepository.getSearchResults(searchQuery).observe(this, new Observer<GenericDataModel<SearchResultModel>>() {
            @Override
            public void onChanged(GenericDataModel<SearchResultModel> searchResultModelGenericDataModel) {
                checkAndSetData(searchResultModelGenericDataModel);
            }
        });
    }

    private void checkAndSetData(GenericDataModel<SearchResultModel> searchResultModelGenericDataModel) {
        if (searchResultModelGenericDataModel != null) {
            if (searchResultModelGenericDataModel.isLoading != null && searchResultModelGenericDataModel.isLoading) {
                mResultTextView.setVisibility(View.GONE);
                mProgressLoading.setVisibility(View.VISIBLE);
            } else {
                if (searchResultModelGenericDataModel.isSuccess != null && searchResultModelGenericDataModel.isSuccess) {
                    SearchResultModel data = searchResultModelGenericDataModel.data;
                    if (data != null && data.getStatus().equalsIgnoreCase("ok") &&
                            data.getData() != null && data.getData().getItems() != null &&
                            data.getData().getItems().size() > 0) {
                        mResultTextView.setText(data.toString());
                    } else {
                        mResultTextView.setText("No data");
                    }
                } else {
                    mResultTextView.setText("No data");
                }
                mResultTextView.setVisibility(View.VISIBLE);
                mProgressLoading.setVisibility(View.GONE);
            }
        } else {
            mResultTextView.setVisibility(View.GONE);
            mProgressLoading.setVisibility(View.GONE);
        }
    }
}