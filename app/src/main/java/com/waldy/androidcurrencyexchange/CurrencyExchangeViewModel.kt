package com.waldy.androidcurrencyexchange

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.waldy.androidcurrencyexchange.api.AppApiService
import retrofit2.Call
import retrofit2.Response

class CurrencyExchangeViewModel (private val apiService: AppApiService): androidx.lifecycle.ViewModel() {
    fun fetchCurrencies() {
        apiService.getCurrencyList().enqueue(object : retrofit2.Callback<Map<String, String>> {
            override fun onResponse(
                call: Call<Map<String, String>?>,
                response: Response<Map<String, String>?>
            ) {
                Log.d("API", "Fetched Data: ${response.body()?.keys}")
            }

            override fun onFailure(
                call: Call<Map<String, String>?>,
                t: Throwable
            ) {
                Log.e("API", "Error fetching currencies", t)
            }
        })
    }
}

class CurrencyExchangeViewModelFactory(private val apiService: AppApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CurrencyExchangeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CurrencyExchangeViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}