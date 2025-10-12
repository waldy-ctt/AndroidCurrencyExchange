package com.waldy.androidcurrencyexchange

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import kotlinx.coroutines.launch

/**
 * This is the main UI container for your application.
 * It is a stateless Composable, meaning it doesn't create or manage its own data.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainActivityScreen() {
    val tabTitles = listOf("Currency Exchange", "Currency Ratio")

    // State for the pager (which page is selected) is managed here, as it's pure UI state.
    val pagerState = rememberPagerState { tabTitles.size }
    val scope = rememberCoroutineScope() // Scope to handle tab click animations

    // Scaffold provides the basic layout structure (like app bars, etc.)
    // The innerPadding automatically handles safe areas like the status bar.
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TabRow(selectedTabIndex = pagerState.currentPage) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            // Animate to the clicked page
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = title,
                                maxLines = 1, // Prevent text from wrapping
                                overflow = TextOverflow.Ellipsis // Add "..." if text is too long
                            )
                        },
                        selectedContentColor = MaterialTheme.colorScheme.primary,
                        unselectedContentColor = MaterialTheme.colorScheme.outline,
                    )
                }
            }

            // This is the pager that swipes between your different screens.
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                // When the page changes, show the corresponding screen's Composable.
                when (page) {
                    0 -> CurrencyExchangeScreen()
                    1 -> CurrencyRatioScreen()
                }
            }
        }
    }
}


// --- Placeholder Screens ---
// In the future, these would be in their own files too (e.g., currency_exchange/CurrencyExchangeScreen.kt)

@Composable
fun CurrencyExchangeScreen() {
    // TODO: Build the UI for the currency exchange feature here
    Text("Content for Currency Exchange")
}

@Composable
fun CurrencyRatioScreen() {
    // TODO: Build the UI for the currency ratio feature here
    Text("Content for Currency Ratio")
}