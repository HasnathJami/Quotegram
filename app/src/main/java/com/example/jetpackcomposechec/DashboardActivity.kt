package com.example.jetpackcomposechec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
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