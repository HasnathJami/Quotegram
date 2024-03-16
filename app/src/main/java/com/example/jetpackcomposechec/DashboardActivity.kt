package com.example.jetpackcomposechec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposechec.screens.categoryScreen
import com.example.jetpackcomposechec.screens.quotesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            populateDashboard()
        }
    }
}

@Composable
fun populateDashboard() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Quotegram")
                },
                backgroundColor = Color.Black,
                contentColor = Color.White
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            App()
        }
    }
}

@Composable
fun App() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "A") {
//        composable(route = "A") {
//            A {
//                navController.navigate("B/${it}")
//            }
//        }
//        composable(route = "B/{id}", arguments = listOf(
//            navArgument("id") {
//                type = NavType.IntType
//            }
//        )) {
//            val id = it.arguments?.getInt("id")
//            B(id)
//        }
//
//    }
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            categoryScreen { category ->
                navController.navigate("quotes/${category}")
            }
        }
        composable(
            route = "quotes/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) {
            quotesScreen()
        }
    }
}


//@Composable
//fun A(onClick: (id:Int) -> Unit) {
//    Text(text = "Screen A", modifier = Modifier.clickable {
//        onClick(123456)
//    })
//}
//
//@Composable
//fun B(id:Int?) {
//    Text(text = "Screen B $id")
//}

@Preview
@Composable
fun showPreview() {
  populateDashboard()
}