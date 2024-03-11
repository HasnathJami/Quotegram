package com.example.jetpackcomposechec.ui.theme

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposechec.ui.theme.ui.theme.JetpackComposeCheCTheme
import kotlinx.coroutines.delay

class SideEffectsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCheCTheme {
                // testSideEffects()
                //testSideEffectsWithProduceState()
                // testSideEffectsWithDerivedState()
                testSideEffectsWithRememberUpdatedState()
            }
        }
    }
}

//@Composable
//fun testSideEffects() {
//    var state by remember {
//        mutableStateOf(0)
//    }
//    val scope = rememberCoroutineScope()
//    Log.d("checkStateCall","state is called $state")
//
////    LaunchedEffect(key1 = state) {
////        Log.d("checkState","process is initialized")
////    }
//    DisposableEffect(key1 = state) {
//       Log.d("checkState","process is initialized")
//        onDispose {
//            Log.d("checkStateDisposal","clean")
//        }
//    }
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Button(onClick = {
//            scope.launch {
//                state++
//            }
//            // state++
//        }) {
//            Text(
//                text = "click"
//            )
//        }
//        Text(
//            text = "Your value is $state"
//        )
//    }
//
//
//}

//@Composable
//fun testSideEffectsWithProduceState() {
//
//    val state by produceState(initialValue = 0) {
//        Log.d("checkState", "process is initialized")
//
////        for (i in 1..10) {
////            delay(1000)
////            value++
////
////        }
//        while (true) {
//            delay(16)
//            value = (value + 10) % 360
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
////        Text(
////            text = "Your value is $state"
////        )
//        Image(
//            imageVector = Icons.Default.Refresh,
//            contentDescription = "",
//            modifier = Modifier
//                .size(60.dp)
//                .rotate(state.toFloat())
//        )
//    }
//
//
//}

//@Composable
//fun testSideEffectsWithDerivedState() {
//
//    val tableOf by remember {
//        mutableStateOf(10)
//    }
//
//    val index by produceState(initialValue = 1) {
//        repeat(9) {
//            delay(1000)
//            value += 1
//        }
//    }
//
//    val message by derivedStateOf {
//        "$tableOf x $index = ${tableOf * index}"
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = message
//        )
//    }
//
//
//}

@Composable
fun testSideEffectsWithRememberUpdatedState() {

    var counter by remember {
        mutableStateOf(-1)
    }

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter = 10
    }

    Counter(counter)


}

@Composable
fun Counter(counter: Int) {
    val state2 by rememberUpdatedState(newValue = counter)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("checkStateValue",state2.toString())

    }
   // Log.d("checkStateValue2",state.value.toString())
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = counter.toString()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetpackComposeCheCTheme {
        //testSideEffects()
        //testSideEffectsWithProduceState()
        // testSideEffectsWithDerivedState()
        testSideEffectsWithRememberUpdatedState()
    }
}