package com.example.taskapp.ui.ui.Layout.screens

import android.content.pm.ActivityInfo
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.taskapp.ui.ui.Layout.components.LockScreenOrientation
import com.example.taskapp.ui.ui.Layout.components.taskButton
import com.example.taskapp.ui.ui.Layout.state.TaskFormUiState
import com.example.taskapp.ui.ui.Layout.buttonBlue
import com.example.taskapp.ui.ui.Layout.dividerColor
import com.example.taskapp.ui.ui.Layout.textfield
import com.example.taskapp.ui.ui.Layout.viewmodel.TaskViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newTaskScreen(navController: NavController, uiState: TaskFormUiState){
    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    val taskViewModel = koinViewModel<TaskViewModel>()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current


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
                            taskViewModel.clearFields()
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
                    scope.launch {
                        if(uiState.title.isEmpty() || uiState.description.isEmpty() || uiState.status.isEmpty()){
                            Toast.makeText(context, "Existe Campo em Branco", Toast.LENGTH_LONG).show()
                        }else{
                            taskViewModel.save()
                            taskViewModel.clearFields()
                            Toast.makeText(context, "Task Criada", Toast.LENGTH_LONG).show()
                        }
                    }

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
                    OutlinedTextField(value = uiState.title,
                        onValueChange =  uiState.onTitleChange ,
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
                    Spacer(modifier = Modifier.height(2.dp))

                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))

                    Spacer(modifier = Modifier.height(2.dp))

                    OutlinedTextField(value = uiState.description,
                        onValueChange =  uiState.onDescriptionChange ,
                        label = { Text(text = ("Descrição"), color = textfield, fontSize = 14.sp) },
                        modifier = Modifier
                            .width(343.dp)
                            .height(52.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor= Color.Transparent
                        )
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))

                    Spacer(modifier = Modifier.height(2.dp))

                    OutlinedTextField(value = uiState.status,
                        onValueChange =  uiState.onStatusChange ,
                        label = { Text(text = ("Status"), color = textfield, fontSize = 14.sp) },
                        modifier = Modifier
                            .width(343.dp)
                            .height(52.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor= Color.Transparent
                        )
                    )

                        }

                    }


                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))


                }

            }
        }


