package com.waldy.androidcurrencyexchange

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.waldy.androidcurrencyexchange.api.AppApiService

class CurrencyExchangeFragment: Fragment(R.layout.currency_exchange_view) {
    private lateinit var viewModel: CurrencyExchangeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService: AppApiService = (requireActivity() as MainActivity).appApiSer

        val inputA = view.findViewById<EditText>(R.id.input_a);

        inputA.setText(0);
    }
}