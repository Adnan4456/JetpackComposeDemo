package com.example.startjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.startjetpackcompose.ui.theme.StartJetPackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartJetPackComposeTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Jetpack Compose")
                            },
                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Menu , contentDescription = "menu")
                                }
                            },
                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Notifications , contentDescription = "notification")
                                }
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Search , contentDescription = "search")
                                }
                            }
                        )
                    },
                    //second parameter floating action button
                floatingActionButton = {
                     FloatingActionButton(onClick = {}) {
                         IconButton(onClick = {}) {
                             Icon(Icons.Filled.Add , contentDescription = "add")
                         }
                     }
                },
                    floatingActionButtonPosition = FabPosition.End

                ) {
                    //Content will appear here. text and other composeable function.
                    Greeting(name = "Jetpack Compose")
                    ShowSwitch()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!"
//        color = MaterialTheme.colors.error
//        modifier = Modifier.size(18.dp)
        )
}

@Composable
fun ShowSwitch(){
    val isChecked = remember{

        mutableStateOf(false)
    }

    Switch(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
        },
        modifier = Modifier.run {
            size(20.dp)
            padding(100.dp)

        }
    )
}

@Preview(showBackground = true , name = "light mode")
//@Preview(showBackground = true , name = "dark mode" ,
//    uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    StartJetPackComposeTheme {
        Greeting("Jetpack Compose")
    }
}