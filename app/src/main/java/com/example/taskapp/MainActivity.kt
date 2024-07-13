package com.example.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.screens.homeScreen
import com.example.taskapp.screens.newTaskScreen
import com.example.taskapp.ui.theme.TaskAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskAppTheme {
                val navController = rememberNavController()
                Navigation(navController)

            }
        }
    }
}



@Composable
fun Navigation(navController:NavHostController){
//    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            homeScreen(navController)
        }
        composable("task"){
            newTaskScreen(navController)
        }
        composable("change"){

        }
    }
}
