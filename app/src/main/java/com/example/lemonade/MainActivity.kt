package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeWithButtonAndImages()
            }
        }
    }
}

@Composable
fun LemonadeWithButtonAndImages(
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    var random by remember { mutableStateOf( 1 ) }
    var result by remember { mutableStateOf(1) }
    if (random == 0) {
        if (result == 1)
            random = (2..4).random()
        else
            random = 1

        if (result == 4)
            result = 1
        else
            result += 1
    }
    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when (result) {
        1 -> R.string.select_lemon
        2 -> R.string.squeeze_lemon
        3 -> R.string.drink_lemon
        else -> R.string.start_again
    }

    Surface (
        modifier = Modifier,
        color = Color.Yellow
    ) {
        Column {

            Text(text = "                                                           ")
            Text(text = "                                                           ")
            Text(text = "                                                           ")

            Text(
                //text = stringResource(id = R.string.app_name),
                text = "               Lemonade                   ",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.primaryContainer
            )

            Text(text = "                                                           ")

        }
    }

    Column (
        modifier = modifier
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box (
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                          random -= 1
                },
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer),
                modifier = Modifier
                    .size(width = 220.dp, height = 220.dp)
            ) {

            }
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "lemon tree",
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        Text (
            stringResource(id = textResource),
            fontSize = 19.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeWithButtonAndImages()
    }
}