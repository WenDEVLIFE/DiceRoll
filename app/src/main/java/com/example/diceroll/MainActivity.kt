package com.example.diceroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroll.ui.theme.DiceRollTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    DicePrev()
                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DicePrev(){
    DiceRollTheme {

        // set the content to center
        DiceImg(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun DiceImg(modifier: Modifier = Modifier){
    var result by remember {  mutableStateOf(1) }

    val calculate = result - 1
    var resultString = "Dice Rolled: $calculate"

    // Load all the images
    val imageResource = when (result) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        6 -> R.drawable.dice6
        else -> R.drawable.dice1
    }

    // Set to column
       Column(  modifier = modifier,
           horizontalAlignment = Alignment.CenterHorizontally) {
           Text(

               // Get the String resources from the strings.xml file
               text = stringResource(R.string.DiceRoll),
               color = MaterialTheme.colorScheme.onBackground,
               fontSize = typography.headlineMedium.fontSize,
               fontWeight = typography.headlineMedium.fontWeight,
               fontFamily = typography.headlineLarge.fontFamily,
               textAlign = TextAlign.Center,
               modifier = Modifier.padding(16.dp)
           )
           Spacer(modifier = Modifier.height(20.dp))

           Text(

               // Get the String resources from the strings.xml file
               text = resultString,
               color = MaterialTheme.colorScheme.onBackground,
               fontSize = typography.headlineMedium.fontSize,
               fontWeight = typography.headlineMedium.fontWeight,
               fontFamily = typography.headlineLarge.fontFamily,
               textAlign = TextAlign.Center,
               modifier = Modifier.padding(16.dp)
           )

           // Added an images
           Image(
               painter = painterResource(imageResource),
               contentDescription = result.toString()
           )
           Spacer(modifier = Modifier.height(46.dp))

           // Added a button
           Button(onClick = {
               
               // SET TO RANDOM
                result = (1..6).random()

               // Display the result
               resultString = "Dice Rolled: {$result}"

           }) {
               Text(stringResource(R.string.roll))
           }
    }
}