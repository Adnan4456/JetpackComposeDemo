package com.example.startjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.startjetpackcompose.ui.theme.StartJetPackComposeTheme

class LoginActivity:ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartJetPackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }
    }

    @Composable
    fun LoginScreen() {

        val username = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }

//        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Hello Jetpack Compose", color = Color.Blue,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 25.sp
            )

            Text(
                text = "Welcome ", color = Color.Blue,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 25.sp
            )

            Text(
                text = "Back", color = Color.Blue,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 25.sp
            )

            OutlinedTextField(
                value = username.value,
                onValueChange = {
                    //If any value changed in edit text it will assigned to username variable.
                    username.value = it
                },
                //adding image to left side of textfield
                leadingIcon = {
                    //It take Icon in lambda function
                    Icon(Icons.Default.Person, contentDescription = "person")
                },
                label = {
                    Text(text = "Username")
                },
                placeholder = {
                    Text(text = "Enter Username")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password.value,
                visualTransformation = if (passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),

                onValueChange = {
                    //If any value changed in edit text it will assigned to username variable.
                    password.value = it
                },
                //adding image to left side of textfield
                leadingIcon = {
                    //It take Icon in lambda function
                    Icon(Icons.Default.Info, contentDescription = "password")
                },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Enter Password")
                },
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwordVisible = !passwordVisible}){
                        Icon(imageVector  = image, description)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedButton(
                onClick = { logged(username.value, password.value) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            {

                Text(text = "Login")

            }
        }
    }

    private fun logged(name: String, pass: String) {
        if (name == "adnan" && pass == "12345") {
            Toast.makeText(this, "Logged ", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "wrong credential", Toast.LENGTH_SHORT).show()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        StartJetPackComposeTheme {
            LoginScreen()
        }
    }
}