package com.example.openweather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openweather.data.GetTimeWeather
import com.example.openweather.data.GetTypeWeather
import com.example.openweather.ui.theme.OpenWeatherTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenWeatherTheme {

            }
        }
    }

    @Composable
    fun Greeting(
        city: String,
        currentWeather: Int,
        weatherTypeList: List<GetTypeWeather>,
        weatherTimeList: List<GetTimeWeather>
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = city,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$currentWeather °C",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 15.dp),
            )
            Text(
                text = getCurrentWeather(currentWeather),
                modifier = Modifier
                    .padding(top = 15.dp),
                color = Color.Gray
            )
            LazyRow {
                items(weatherTypeList) {
                    TypeWeather(it)
                }
            }
            LazyRow {
                items(weatherTimeList) {
                    TimeWeather(it)
                }
            }
        }
    }

    @Composable
    fun TypeWeather(getTypeWeather: GetTypeWeather) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
        ) {
            Text(
                text = "${getTypeWeather.temp} °C",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = getTypeWeather.typeWeather,
                fontSize = 12.sp,
            )
        }
    }

    @Composable
    fun TimeWeather(getTypeWeather: GetTimeWeather) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 60.dp, 0.dp, 20.dp),
        ) {
            Text(
                text = "${getTypeWeather.temp }°C",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = getTypeWeather.time,
                fontSize = 12.sp
            )
        }
    }

    private fun getCurrentWeather(current: Int): String {
        return if (current > 40) {
            HOT
        } else if (current in 16..39) {
            HEAT
        } else {
            COLD
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        OpenWeatherTheme {
            Greeting(
                "Москва", 20, listOf(
                    GetTypeWeather(
                        10, "Холодно"
                    ),
                    GetTypeWeather(
                        12, "Холодно"
                    ),
                    GetTypeWeather(
                        15, "Солнечно"
                    ),
                    GetTypeWeather(
                        18, "Солнечно"
                    ),
                    GetTypeWeather(
                        21, "Солнечно"
                    ),
                    GetTypeWeather(
                        24, "Тепло"
                    ),
                    GetTypeWeather(
                        27, "Жарко"
                    ),
                ), listOf(
                    GetTimeWeather(
                        5, "9:00"
                    ),
                    GetTimeWeather(
                        10, "12:00"
                    ),
                    GetTimeWeather(
                        15, "15:00"
                    ),
                    GetTimeWeather(
                        20, "18:00"
                    ),
                    GetTimeWeather(
                        25, "21:00"
                    ),
                    GetTimeWeather(
                        30, "22:00"
                    ),
                    GetTimeWeather(
                        35, "23:00"
                    ),
                )
            )
        }
    }

    companion object {
        const val HEAT = "Тепло"
        const val HOT = "Жарко"
        const val COLD = "Холодно"
    }
}