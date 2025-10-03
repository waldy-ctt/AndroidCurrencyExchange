package com.waldy.androidcurrencyexchange

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.waldy.androidcurrencyexchange.api.AppApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var appApiServiceInstance: AppApiService

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // INIT API CALL SERVICE
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        appApiServiceInstance = retrofit.create<AppApiService>(AppApiService::class.java);

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout);
        val viewPager = findViewById<ViewPager2>(R.id.viewPager);
        val tabTitle = arrayOf("Currency Exchange", "Currency Ratio");

        val adapter = TabAdapter(this);
        viewPager.adapter = adapter;

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitle[position];
        }.attach();

    }
}