package ua.edu.lntu.cw_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.edu.lntu.cw_2.ui.theme.IPZ_CW_2_PetlenkoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_2_PetlenkoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var currentState by remember{ mutableStateOf(1) }
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var emailTextValue by remember { mutableStateOf("") }


    when(currentState)  {
        1 ->  Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextField(
                value = emailValue,
                label = {
                    Text(text = "Email")
                },
                onValueChange = { newText -> emailValue = newText }
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextField(
                value = passwordValue,
                label = {
                    Text(text = "Password")
                },
                onValueChange = { newText -> passwordValue = newText }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    if ( (emailValue != "") && passwordValue != ""){
                        emailTextValue = emailValue
                        emailValue = ""
                        passwordValue = ""
                        currentState = 2
                    }
                }) {
                Text(text = "Sign In")
            }
        }
        2 ->
            Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Sing In Success",
                fontSize = 30.sp
            )
            Text(text = emailTextValue)
            Button(onClick = { currentState = 1 }) {
                Text(
                    text = "Sing out",
                    fontSize = 20.sp
                )
            }
        }
    }

}
