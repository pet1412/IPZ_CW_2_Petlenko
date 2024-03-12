package ua.edu.lntu.cw_2

import android.os.Bundle
import android.widget.Space
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var currentState by remember{ mutableStateOf(2) }

    when(currentState)  {
        1 -> SingIn()
        2 -> SingInSuccess(email = "")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IPZ_CW_2_PetlenkoTheme {
        Greeting()
    }
}

@Composable
fun SingIn(){
    var emailValue by remember { mutableStateOf("") }
    var passworValue by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login")
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = emailValue,
            onValueChange = { newText -> emailValue = newText }
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = passworValue,
            onValueChange = { newText -> passworValue = newText }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { /*TODO*/ }) {
            Text(text = "Sign In")
        }
    }
}

@Composable
fun SingInSuccess(email: String){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sing In Success")
        Text(text = email)
        Button(onClick = { /*TODO*/ }) {
                Text(text = "Sing out")
        }
    }
}
