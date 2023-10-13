package com.example.openweather.presentation
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class OpenWeatherBottomAppBar {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
     fun MyApp() {
        Scaffold (
            topBar = {
                AppBar(title = "OpenWeather")
            },
        )  { innerPadding ->

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppBar(title: String) {
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.clickable {}
                )
            }, actions = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Menu",
                    modifier = Modifier.clickable {}
                )
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Menu",
                    modifier = Modifier.clickable {}
                )
            }
        )
    }
}