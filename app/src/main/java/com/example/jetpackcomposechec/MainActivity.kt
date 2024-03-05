package com.example.jetpackcomposechec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposechec.ui.theme.JetpackComposeCheCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCheCTheme {
                subscribeUiToRecyclerView()
            }

        }
    }
}

data class User(
    val name: String,
    val email: String
)

@Composable
fun subscribeUiToRecyclerView() {
    val users: ArrayList<User> = ArrayList()
    users.add(User("jami", "jami@gmail.com"))
    users.add(User("hasnath", "hasnath@gmail.com"))
    users.add(User("chowdhury", "chowdhury@gmail.com"))

    populateRecyclerview(users)
}

@Composable
fun populateRecyclerview(users: List<User>) {
    val state = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 36.dp, end = 36.dp, top = 16.dp, bottom = 16.dp)
    ) {

        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            label = { Text(text = "Search") },
            placeholder = { Text(text = "Enter your name") },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        LazyColumn(
            content = {
                items(users) { user ->
                    singleRowDesign(user)
                }
            })
    }

}

//@Composable
//fun testDesign() {
//    Text(
//        text = "Hello $name!",
//        //textAlign = TextAlign.Center,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Green)
//            .wrapContentSize(Alignment.Center),
//        fontSize = 36.sp,
//        fontWeight = FontWeight.Bold,
//        color = Color.Red,
//
//    )

//    Button(onClick = {
//
//    }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)) {
//        //Image(painter = painterResource(id = R.drawable.ic_launcher_foreground)  , contentDescription = null)
//        Icon(
//            imageVector = Icons.Default.Add,
//            contentDescription = null,
//            tint = Color.Green
//        )
//       Text(
//           text = "Click me",
//           textDecoration = TextDecoration.LineThrough,
//       )
//
//    }
//}

@Composable
fun singleRowDesign(user: User) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = Color.Gray, RoundedCornerShape(12.dp))
            .border(2.dp, color = Color.Red, RoundedCornerShape(12.dp))
            .padding(0.dp, 16.dp, 0.dp, 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp),
            colorFilter = ColorFilter.tint(Color.Blue),
            contentScale = ContentScale.Fit

        )
        Column(
            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .fillMaxWidth()
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = user.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = user.email,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 10.dp),
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(
            modifier = Modifier
                .width(18.dp)
                .weight(1f)
        )
        Button(
//            modifier = Modifier
//                .width(20.dp)
//                .height(20.dp),
            modifier = Modifier.padding(end = 10.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.Black
            ),


            ) {
            Text(
                text = "view",
                fontSize = 14.sp,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCheCTheme {
        subscribeUiToRecyclerView()
    }
}