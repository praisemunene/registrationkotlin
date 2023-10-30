  package com.example.loginregistration

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginregistration.ui.theme.LoginRegistrationTheme
import com.example.loginregistration.ui.theme.backcolor

  class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegistrationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Homescreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homescreen() {
  Column (
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally
  ){
    Text(
        text = "Register here",
        color = backcolor,
        fontFamily = FontFamily.Cursive,
        textDecoration = TextDecoration.Underline,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
      Spacer(modifier = Modifier.height(10.dp))
    var name by remember { mutableStateOf("") }
      OutlinedTextField(
          value = name,
          onValueChange = {name = it },
          label = { Text(text = "Enter name")},
          modifier = Modifier.width(360.dp),
          keyboardOptions = KeyboardOptions(
              capitalization = KeyboardCapitalization.Words,
              keyboardType = KeyboardType.Text,
              imeAction = ImeAction.Next
          )
      )
      Spacer(modifier = Modifier.height(20.dp))
      var email by remember {
          mutableStateOf("")
      }
      OutlinedTextField(
          value = email,
          onValueChange = {email = it},
          label = { Text(text = "Enter email")},
          modifier = Modifier.width(360.dp),
//          Shape = RoundedCornerShape(20.dp),
          keyboardOptions = KeyboardOptions(
              capitalization = KeyboardCapitalization.None,
              keyboardType = KeyboardType.Email,
              imeAction = ImeAction.Next
          )
      )

      Spacer(modifier = Modifier.height(20.dp))
      var idnumber by remember {
          mutableStateOf("")
      }
      OutlinedTextField(
          value = idnumber,
          onValueChange = {idnumber = it},
          label = { Text(text = "Enter id number")},
          modifier = Modifier.width(360.dp),
//          Shape = RoundedCornerShape(20.dp),
          keyboardOptions = KeyboardOptions(
              capitalization = KeyboardCapitalization.None,
              keyboardType = KeyboardType.Email,
              imeAction = ImeAction.Next
          )
      )

      Spacer(modifier = Modifier.height(20.dp))
      var password by remember {
          mutableStateOf("")
      }
      OutlinedTextField(
          value = password,
          onValueChange = {password = it},
          label = { Text(text = "Enter password")},
          modifier = Modifier.width(360.dp),
//          Shape = RoundedCornerShape(20.dp),
          keyboardOptions = KeyboardOptions(
              capitalization = KeyboardCapitalization.None,
              keyboardType = KeyboardType.Password,
              imeAction = ImeAction.None
          )
      )
      Spacer(modifier = Modifier.height(20.dp))
      var context = LocalContext.current
      var registrationdetails = "$name\n $email\n $idnumber\n$password"
      Button(onClick = {
          Toast.makeText(context, registrationdetails, Toast.LENGTH_SHORT).show()
      }) {
          Text(text = "Rgister here")
      }
  }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LoginRegistrationTheme {
        Homescreen()
    }
}