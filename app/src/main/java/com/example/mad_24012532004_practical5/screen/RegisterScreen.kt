package com.example.mad_24012532004_practical5.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mad_24012532004_practical5.R
import com.example.mad_24012532004_practical5.screen.components.FormField
import com.example.mad_24012532004_practical5.ui.theme.Blue
import com.example.mad_24012532004_practical5.ui.theme.GuniPink
import com.example.mad_24012532004_practical5.ui.theme.MAD_24012532004_Practical5Theme


@Composable
fun RegisterUI( onLoginClicked: () -> Unit ){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var num by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var cnfpassword by remember { mutableStateOf("") }


    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier.fillMaxSize().padding(20.dp).verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(130.dp)
                .align(Alignment.CenterHorizontally)

        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            //colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ){
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                // Name Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Name", modifier = Modifier.width(100.dp), fontSize = 16.sp)
                    FormField(
                        label = "Name",
                        textState = name,
                        onTextField = { name = it }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Phone Number", modifier = Modifier.width(100.dp), fontSize = 16.sp)
                    FormField(
                        label = "Phone Number",
                        textState = num,
                        onTextField = { num = it },
                        isNumber = true
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "City", modifier = Modifier.width(100.dp), fontSize = 16.sp)
                    FormField(
                        label = "City",
                        textState = city,
                        onTextField = { city = it }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Email", modifier = Modifier.width(100.dp), fontSize = 16.sp)
                    FormField(
                        label = "Email",
                        textState = email,
                        onTextField = { email = it }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Password", modifier = Modifier.width(100.dp), fontSize = 16.sp)
                    FormField(
                        label = "Password",
                        textState = password,
                        onTextField = { password = it },
                        isPasswordField = true
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Confirm Password", modifier = Modifier.width(100.dp), fontSize = 16.sp)
                    FormField(
                        label = "Password Again",
                        textState = cnfpassword,
                        onTextField = { cnfpassword = it },
                        isPasswordField = true
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { /*TODO: Handle Login*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Blue
                    )
                ) {
                    Text(text = "Register", fontSize = 18.sp)
                }

            }
        }

        //Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.weight(2f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Don you have an account?", color = MaterialTheme.colorScheme.onBackground)
            TextButton(onClick = { onLoginClicked() }) {
                Text("LOGIN", fontWeight = FontWeight.Bold, color = GuniPink)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showRegisterUI(){
    MAD_24012532004_Practical5Theme(darkTheme = false) {
        RegisterUI(onLoginClicked = {})
    }
}
