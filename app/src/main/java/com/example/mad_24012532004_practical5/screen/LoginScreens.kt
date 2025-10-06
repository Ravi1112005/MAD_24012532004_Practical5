package com.example.mad_24012532004_practical5.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.mad_24012532004_practical5.ui.theme.GuniPink


@Composable
fun LoginUI(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)) {
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
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)

        ){
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                // Email Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Email", modifier = Modifier.width(80.dp), fontSize = 18.sp)
                    FormField(
                        label = "Email",
                        textState = email,
                        onTextField = { email = it }
                    )
                }


                // Password Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(text = "Password", modifier = Modifier.width(80.dp).padding(top = 35.dp), fontSize = 18.sp)
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        FormField(
                            modifier = Modifier.fillMaxWidth(),
                            label = "Password",
                            textState = password,
                            onTextField = { password = it },
                            isPasswordField = true
                        )
                        TextButton(
                            onClick = { /*TODO: Handle Forgot Password*/ },
                            contentPadding = PaddingValues(top = 0.dp, bottom = 0.dp, end = 10.dp)
                        ) {
                            Text(text = "Forgot Password?")
                        }
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { /*TODO: Handle Login*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Login", fontSize = 18.sp)
                }

            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        //Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Don't have an account?")
            TextButton(onClick = { /*TODO: Handle Sign Up navigation*/ }) {
                Text("SIGN UP", fontWeight = FontWeight.Bold, color = GuniPink)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showLoginUI(){
    LoginUI()
}
