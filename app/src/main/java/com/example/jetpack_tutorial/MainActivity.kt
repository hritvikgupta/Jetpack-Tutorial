package com.example.jetpack_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_tutorial.ui.theme.JetpackTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTutorialTheme {
                var name by remember {
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                // A surface container using the 'background' color from the theme
//                Greeting(name = "Android")
//                var count by remember{
//                   mutableStateOf(0)
//                }
//                Column(modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally) {
//                    Text(text = count.toString(),
//                    fontSize = 20.sp)
//                    Button(onClick = {
//                            count++
//                    }) {
//                        Text(text = "Click Me: $count")
//                    }
//
//                }
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(value = name,
                            onValueChange = {text ->
                                name = text

                            },
                        modifier = Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if( name.isNotBlank()){
                                names = names +name
                                name = ""
                            }

                        }) {
                            Text(text = "Add")
                        }
                        
                    }
                    previewName(names = names)
//                    LazyColumn{
//                        items(names){currentName->
//                            Text(
//                                text = currentName,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .width(16.dp)
//                            )
//                            Divider()
//                        }
//
//                    }

                }
            }
        }
    }
}

@Composable
fun previewName(names:List<String>, modifier: Modifier = Modifier) {
        LazyColumn(modifier) {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(16.dp)
                )
                Divider()
            }

        }


}
@Composable
fun Greeting(name: String) {
//    Column(//parent Layout
//    horizontalAlignment = Alignment.CenterHorizontally,
//    modifier = Modifier.size(400.dp),
//        verticalArrangement = Arrangement.Center
//
//    )
//    Row(
//        horizontalArrangement = Arrangement.End
//       )
//    Box(
//        modifier = Modifier.size(400.dp),
//        contentAlignment = Alignment.Center
//    ){//Child elements
//        Text(
//            text = "Hello $name!",
//            color = Color.Blue,
//            fontSize = 30.sp,
//            modifier = Modifier
//                .background(Color.Red) //Modifiers works sequentially
//                .padding(16.dp)
//                .background(Color.Green)
//                .align(Alignment.BottomEnd)
//
//        )
//        Text(
//            text = "Hello Another Text",
//            color = Color.Blue,
//            fontSize = 30.sp
//        )
//        if (name.length > 5){
//        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription =null ,
//        modifier = Modifier.align(Alignment.CenterEnd).background(Color.Black).padding(5.dp))
//    }
//    }
    //Creating the list
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(10){i->
            Icon(imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(100.dp))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackTutorialTheme {
        previewName(listOf())
    }
}