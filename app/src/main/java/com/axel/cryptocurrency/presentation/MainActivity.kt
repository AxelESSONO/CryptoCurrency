package com.axel.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.axel.cryptocurrency.presentation.coin_detail.CoinDetailScreen
import com.axel.cryptocurrency.presentation.coin_list.CoinListScreen
import com.axel.cryptocurrency.presentation.ui.theme.CryptoCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    val navController = rememberNavController()
                   NavHost(
                       navController = navController,
                       startDestination = Screen.CoinListScreen.route
                   ){

                       composable(
                           route = Screen.CoinListScreen.route
                       ){
                           CoinListScreen(navController = navController)
                       }

                       composable(
                           route = Screen.CoinDetailScreen.route + "/{coinId}"
                       ){
                           CoinDetailScreen()
                       }
                   }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptoCurrencyTheme {
        Greeting("Android")
    }
}