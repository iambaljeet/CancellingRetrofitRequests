package com.app.cancellingretrofitrequests.kotlin.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.app.cancellingretrofitrequests.R
import com.app.cancellingretrofitrequests.kotlin.model.GenericDataModel
import com.app.cancellingretrofitrequests.kotlin.model.SearchResultModel
import com.app.cancellingretrofitrequests.kotlin.repository.DataRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var apiJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText?.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                resultTextView?.visibility = View.GONE
                progressLoading?.visibility = View.VISIBLE
                apiJob?.cancel()

                startSearching(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun startSearching(searchQuery: String?) {
        apiJob = CoroutineScope(Dispatchers.IO).launch {
            DataRepository.getSearchResults(searchQuery)

            withContext(Dispatchers.Main) {
                DataRepository.searchResultsLiveData.observe(
                    this@MainActivity,
                    Observer { genericDataModel: GenericDataModel<SearchResultModel>? ->
                        run {
                            checkAndSetData(genericDataModel)
                        }
                    })
            }
        }
    }

    private fun checkAndSetData(genericDataModel: GenericDataModel<SearchResultModel>?) {
        if (genericDataModel != null) {
            if (genericDataModel.isLoading == true) {
                resultTextView?.visibility = View.GONE
                progressLoading?.visibility = View.VISIBLE
            } else {
                if (genericDataModel.isSuccess == true) {
                    val data = genericDataModel.data
                    if (data?.status.equals("OK", true) && data?.data?.items?.size ?: 0 > 0) {
                        resultTextView?.text = data.toString()
                    } else {
                        resultTextView?.text = "No data"
                    }
                } else {
                    resultTextView?.text = "No data"
                }

                resultTextView?.visibility = View.VISIBLE
                progressLoading?.visibility = View.GONE
            }
        } else {
            resultTextView?.visibility = View.GONE
            progressLoading?.visibility = View.GONE
        }
    }
}
