package com.example.jetpackcomposechec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            populateUi()
        }
    }

    @Composable
    fun populateUi() {
//        Column(Modifier.verticalScroll(rememberScrollState())) {
//            getCustomers().map { customer ->
//                singleRowDesign(
//                    customer.customerImage,
//                    customer.customerName,
//                    customer.customerNumber
//                )
//            }
//        }
        LazyColumn(content = {
            items(getCustomers()) { customer ->
                singleRowDesign(
                    customer.customerImage,
                    customer.customerName,
                    customer.customerNumber
                )

            }
        })
    }

    @Composable
    fun singleRowDesign(image: Int, name: String, number: String) {
        Card(
            elevation = 8.dp,
            modifier = Modifier
                .padding(8.dp),
            // .background(Color.Blue),
            backgroundColor = Color.Red,
            border = BorderStroke(1.dp, Color.Blue)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(end = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .weight(0.2f),
                    colorFilter = ColorFilter.tint(Color.Gray)
                )

                itemDescription(name, number, Modifier.weight(0.8f))
            }
        }

    }

    @Composable
    private fun itemDescription(name: String, number: String, modifier: Modifier) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = number,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp
            )
        }
    }


//    @Composable
//    fun Greeting(name: String) {
////        Row(
////            modifier = Modifier
////                .fillMaxSize(),
////            horizontalArrangement = Arrangement.Center,
////            verticalAlignment = Alignment.CenterVertically
////        ) {
////            Text(text = "Content 1")
////            Text(text = "Content 2")
////        }
////        Column(modifier = Modifier.fillMaxSize()) {
////            Image(
////                painter = painterResource(id = R.drawable.ic_launcher_foreground),
////                contentDescription = "",
////                colorFilter = ColorFilter.tint(Color.Blue),
////                modifier = Modifier
////                    .background(Color.Green)
////                    .clip(CircleShape)
////                    .size(40.dp)
////                    .background(Color.Red)
////                    .border(2.dp, Color.Black, CircleShape)
////                    .clickable {
////                        Log.d("checkClick", "I am clicked")
////                    },
////                contentScale = ContentScale.Crop,
////                alpha = 0.5f,
////                )
////        }
//
////        Box(
////            modifier = Modifier
////                .fillMaxSize(),
////            contentAlignment = Alignment.CenterStart
////
////        ) {
////            Text("Content 1")
////            Text("Content 2")
////        }
////
////
//    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        populateUi()
    }

    fun getCustomers(): MutableList<Customer> {
        val customers = mutableListOf<Customer>()
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Hasnath", "01478855555"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Jami", "015555888666"))
        customers.add(Customer(R.drawable.ic_launcher_foreground, "Chowdhury", "000000000000000"))
        return customers
    }

    data class Customer(
        val customerImage: Int,
        val customerName: String,
        val customerNumber: String
    )

}