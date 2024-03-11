package com.example.jetpackcomposechec.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposechec.ui.theme.ui.theme.JetpackComposeCheCTheme

class ThemeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            App()

        }
    }
}

@Composable
fun App() {
    var themes = remember { mutableStateOf(false) }
    JetpackComposeCheCTheme(themes.value) {
       // LocalConfiguration.current.
        LocalContext.current.applicationContext
        Column(Modifier.background(MaterialTheme.colors.background)) {
            Text(text = "Hello Jami!")
            Button(onClick = { themes.value = !themes.value }) {

                Text(text = "Change Theme!")
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    App()
}