package com.example.taskapp.ui.ui.Layout.components

import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.taskapp.models.TaskModel
import com.example.taskapp.ui.ui.Layout.backButton
import com.example.taskapp.ui.ui.Layout.buttonBlue
import com.example.taskapp.ui.ui.Layout.redbutton
import com.example.taskapp.ui.ui.Layout.viewmodel.TaskViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun SimulatioScreen(){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        //CardItem(title = "Tarefa", description = "mknkjbk", status = "Pendente")

    }
}

@Composable
fun CardItem(task: TaskModel, navController: NavController){
    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateFloatAsState(targetValue = if (expanded) 200f else 0f, label = "")
    val scope = rememberCoroutineScope()
    val taskViewModel = koinViewModel<TaskViewModel>()

    OutlinedCard (modifier = Modifier
        //.height(50.dp)
        .fillMaxWidth()
        .padding(5.dp)
        .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )){
        Column (modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
        ){
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Título", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(text = task.title, fontSize = 14.sp)
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "",
                    modifier = Modifier.rotate(if (expanded) 180f else 0f)
                )

            }
            Spacer(modifier = Modifier.height(25.dp))
            if (expanded){
                Column (modifier = Modifier.padding(5.dp)){
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Decrição", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(text = task.description, fontSize = 14.sp)

                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Status", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(text = task.status, fontSize = 14.sp)

                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        DeleteButton(onDeleteClick = {
                            scope.launch {
                                taskViewModel.delete(task)
                            }
                        })
                        UpdateButton {

                        }

                    }
                }

            }


        }

    }
}

@Composable
fun DeleteButton(onDeleteClick: () -> Unit){
    val scope = rememberCoroutineScope()
    val viewModel = koinViewModel<TaskViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    Box(modifier = Modifier
        .height(24.dp)
        .width(89.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(redbutton)
        .clickable {
            onDeleteClick()

        },
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Deletar", fontSize = 10.sp, color = Color.White)
    }
}

@Composable
fun UpdateButton(onChangeButton:() -> Unit){
    Box(modifier = Modifier
        .height(24.dp)
        .width(89.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(backButton)
        .clickable {
            onChangeButton()
        },
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Alterar", fontSize = 10.sp, color = buttonBlue)
    }
}

@Preview
@Composable
fun CardItemPreview(){
    SimulatioScreen()
}