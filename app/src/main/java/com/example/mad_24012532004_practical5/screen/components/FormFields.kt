package com.example.mad_24012532004_practical5.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormField(
    modifier: Modifier = Modifier,
    label: String,
    textState: String,
    onTextField: (String) -> Unit,
    isPasswordField: Boolean = false,
    isNumber: Boolean = false,

    ){
    Row (modifier = Modifier.padding(10.dp)) {
        if (!isNumber){
            OutlinedTextField(
                value = textState,
                onValueChange = onTextField,
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                visualTransformation = (
                        if (!isPasswordField){
                            VisualTransformation.None
                        }else{
                            PasswordVisualTransformation()
                        }
                        ),
                label = { Text("Enter $label") },
                placeholder = { Text("Enter $label") }
            )
        }
        else{
            NumericOutLinedTextField(
                label = label,
                value = textState,
                onTextChange = onTextField,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Composable
fun NumericOutLinedTextField(
    label: String,
    value: String,
    modifier: Modifier,
    onTextChange: (String) -> Unit,
){
    OutlinedTextField(
        value = value,
        onValueChange = {
                newText ->
            if (newText.all { it.isDigit()}){
                onTextChange(newText)
            }
        },
        modifier = modifier,
        // Correction: The label parameter needs a composable lambda
        label = { Text("Enter $label") },
        textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
        // Correction: The placeholder parameter needs a composable lambda
        placeholder = { Text("Enter $label") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        visualTransformation = VisualTransformation.None
    )
}

@Preview(showBackground = true)
@Composable
fun FormFieldPreview() {
    FormField(label = "Name" , textState = "" , onTextField = { newText ->  })
}
