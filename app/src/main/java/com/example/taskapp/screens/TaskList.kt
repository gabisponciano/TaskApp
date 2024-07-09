package com.example.taskapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskapp.components.progressButton
import com.example.taskapp.components.taskButton
import com.example.taskapp.ui.theme.buttonBlue
import com.example.taskapp.ui.theme.textfield
import com.example.taskapp.ui.theme.texthin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun taskList(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Text("Projeto",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp)
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = buttonBlue)

                    }
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
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Box(modifier = Modifier.height(39.dp)){
                progressButton()
            }

            Box(contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .height(65.dp)
                    .width(327.dp)
            ){
                Column (verticalArrangement = Arrangement.spacedBy(16.dp)){
                    Text(text = "Lista", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Itens marcados como concluídos", fontSize = 14.sp, color = texthin)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedCard (modifier = Modifier
                .height(215.dp)
                .width(327.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ){
                Column (modifier = Modifier.padding(10.dp)){
                    Row (){
                        Text(text = "Título", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Lorem Ipsum", fontSize = 14.sp)
                    }
                }

                Column (modifier = Modifier.padding(10.dp)){
                    Row (){
                        Text(text = "Descrição", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Lorem Ipsum", fontSize = 14.sp)
                    }
                }



            }

            Box {
                taskButton(tittle = "Crie uma Tesk")
            }
        }
    }
}

@Preview
@Composable
fun listPreview(){
    taskList()
}