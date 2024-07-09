package com.example.taskapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.taskapp.components.taskButton
import com.example.taskapp.ui.theme.backButton
import com.example.taskapp.ui.theme.buttonBlue
import com.example.taskapp.ui.theme.dividerColor
import com.example.taskapp.ui.theme.textfield
import com.example.taskapp.viewmodel.ChangeViewModel
import com.example.taskapp.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun changeTaskScreen(){

    val changeViewModel = viewModel<ChangeViewModel>()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.White
                ),


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

                        }
                    )
                }
            )
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
                    OutlinedTextField(value = changeViewModel.tittle.value,
                        onValueChange = {changeViewModel.tittleTask(it)},
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

                    OutlinedTextField(value = changeViewModel.description.value,
                        onValueChange = {changeViewModel.descriptionTask(it)},
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
                            Text(text = "Status",fontSize = 14.sp, color = textfield)
                            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){
                                Box(modifier = Modifier
                                    .height(24.dp)
                                    .width(81.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(backButton)
                                    .clickable {},
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Text(text = "PENDENTE", fontSize = 10.sp, color = buttonBlue)
                                }
                                Box(modifier = Modifier
                                    .height(24.dp)
                                    .width(109.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(backButton)
                                    .clickable {},
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Text(text = "EM PROGRESSO", fontSize = 10.sp, color = buttonBlue)
                                }

                                Box(modifier = Modifier
                                    .height(24.dp)
                                    .width(89.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(backButton)
                                    .clickable {},
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Text(text = "TERMINADO", fontSize = 10.sp, color = buttonBlue)
                                }

                            }

                        }

                    }
                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))


                    Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))



                }


            }
            Box {
                taskButton(tittle = "Criar")
            }
        }
    }
}

@Preview
@Composable
fun changeScreenPreview(){
    changeTaskScreen()
}