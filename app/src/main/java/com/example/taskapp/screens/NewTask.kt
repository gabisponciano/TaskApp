package com.example.taskapp.screens

import android.content.pm.ActivityInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.components.LockScreenOrientation
import com.example.taskapp.components.taskButton
import com.example.taskapp.ui.theme.backButton
import com.example.taskapp.ui.theme.buttonBlue
import com.example.taskapp.ui.theme.dividerColor
import com.example.taskapp.ui.theme.textfield
import com.example.taskapp.ui.theme.texthin
import com.example.taskapp.viewmodel.TaskViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newTaskScreen(navController: NavController){

    val taskViewModel = koinViewModel<TaskViewModel>()
    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(5.dp),
                colors = topAppBarColors(
                    containerColor = Color.White
                ),

                navigationIcon ={ Text(text = "Cancelar",
                    fontSize = 12.sp,
                    color = buttonBlue,
                    modifier = Modifier.clickable { navController.navigate("home") }

                )}
                ,
                title = {
                    Text("Nova Task",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp)
                },
                actions = {
                    Text(text = "Limpar",
                        fontSize = 12.sp,
                        color = buttonBlue,
                        modifier = Modifier.clickable {
                            taskViewModel.clearFilds()

                        }
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar (
                containerColor = Color.White
            ){
                taskButton(title = "Criar") {
                    taskViewModel.saveTask()
                    navController.navigate("home")

                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(300.dp),
        ) {
            Box (modifier = Modifier
                .height(320.dp)
                .fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    OutlinedTextField(value = taskViewModel.title,
                        onValueChange = { taskViewModel.title = it },
                        singleLine = true,
                        label = { Text(text = ("Título"), color = textfield, fontSize = 14.sp) },
                        modifier = Modifier
                            .width(343.dp)
                            .height(52.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor= Color.Transparent
                        )
                    )

                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))

                    OutlinedTextField(value = taskViewModel.description,
                        onValueChange = { taskViewModel.description = it },
                        label = { Text(text = ("Descrição"), color = textfield, fontSize = 14.sp) },
                        modifier = Modifier
                            .width(343.dp)
                            .height(52.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor= Color.Transparent
                        )
                    )

                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))

                    Box (modifier = Modifier
                        .height(100.dp)
                        .width(343.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Column (verticalArrangement = Arrangement.spacedBy(18.dp)){
                            TaskStatusSelector(taskViewModel = taskViewModel)
//                            Text(text = "Status",fontSize = 14.sp, color = textfield)
//                            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){
//                                Box(modifier = Modifier
//                                    .height(24.dp)
//                                    .width(81.dp)
//                                    .clip(RoundedCornerShape(10.dp))
//                                    .background(backButton)
//                                    .clickable {},
//                                    contentAlignment = Alignment.Center
//                                )
//                                {
//                                    Text(text = "PENDENTE", fontSize = 10.sp, color = buttonBlue)
//                                }
//                                Box(modifier = Modifier
//                                    .height(24.dp)
//                                    .width(109.dp)
//                                    .clip(RoundedCornerShape(10.dp))
//                                    .background(backButton)
//                                    .clickable {},
//                                    contentAlignment = Alignment.Center
//                                )
//                                {
//                                    Text(text = "EM PROGRESSO", fontSize = 10.sp, color = buttonBlue)
//                                }
//
//                                Box(modifier = Modifier
//                                    .height(24.dp)
//                                    .width(89.dp)
//                                    .clip(RoundedCornerShape(10.dp))
//                                    .background(backButton)
//                                    .clickable {},
//                                    contentAlignment = Alignment.Center
//                                )
//                                {
//                                    Text(text = "TERMINADO", fontSize = 10.sp, color = buttonBlue)
//                                }
//
//                            }

                        }

                    }
                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))


                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))


                }

            }
        }
    }
}

@Composable
fun TaskStatusSelector(taskViewModel: TaskViewModel) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .width(343.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
            Text(text = "Status", fontSize = 14.sp, color = textfield)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // Implementação dos botões de status
                StatusButton("PENDENTE", taskViewModel)
                StatusButton("EM PROGRESSO", taskViewModel)
                StatusButton("TERMINADO", taskViewModel)
            }
        }
    }
    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))
}

@Composable
fun StatusButton(status: String, taskViewModel: TaskViewModel) {
    Box(
        modifier = Modifier
            .height(24.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backButton)  // backButton é a cor de fundo
            .clickable { taskViewModel.status = status },
        contentAlignment = Alignment.Center
    ) {
        Text(text = status, fontSize = 10.sp, color = buttonBlue)
    }
}


@Preview
@Composable
fun newTaskScreenPreview(){
    newTaskScreen(navController = rememberNavController())
}
