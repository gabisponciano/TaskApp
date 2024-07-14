package com.example.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.ui.ui.Layout.screens.HomeScreen
import com.example.taskapp.ui.ui.Layout.screens.newTaskScreen
import com.example.taskapp.ui.ui.Layout.state.TasksListUiState
import com.example.taskapp.ui.ui.Layout.TaskAppTheme
import com.example.taskapp.ui.ui.Layout.viewmodel.HomeViewModel
import com.example.taskapp.ui.ui.Layout.viewmodel.TaskViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

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
    NavHost(navController = navController, startDestination = "task"){
        composable("home"){
            val viewModel = koinViewModel<HomeViewModel>()
            val uiState by viewModel.uiState
                .collectAsState(TasksListUiState())
            HomeScreen(navController,
                uiState = uiState,
                onSaveClick = {
                    navController.navigate("task")
                }

            )
        }
        composable("task"){
            val scope = rememberCoroutineScope()
            val viewModel = koinViewModel<TaskViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            newTaskScreen(navController,
                uiState = uiState,
                onSaveCLick = {
                    scope.launch {
                        viewModel.save()
                        navController.popBackStack()
                    }
                }

            )
        }
        composable("change"){

        }
    }
}
