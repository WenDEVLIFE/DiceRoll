package com.example.diceroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroll.ui.theme.DiceRollTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollTheme {
                DiceImg(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DicePrev(){
    DiceRollTheme {
        DiceImg()
    }
}

@Preview(showBackground = true)
@Composable
fun DiceImg(modifier: Modifier = Modifier){
    DiceRollTheme {

    }
}