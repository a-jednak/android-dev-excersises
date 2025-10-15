package com.example.aplikacjaczwarta


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplikacjaczwarta.ui.theme.AplikacjaCzwartaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplikacjaCzwartaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageWithText(
                        main = stringResource(id = R.string.main),
                        sub = stringResource(R.string.sub_text),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextHere(main: String, sub: String, modifier: Modifier = Modifier) {
    Text(
        text = main,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .padding(top = 24.dp, bottom = 8.dp)
    )
    Text(
        text = sub,
        fontSize = 16.sp,
        modifier = modifier
    )
}

@Composable
fun ImageWithText(main: String, sub: String, modifier: Modifier = Modifier)
{
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Image(
            painter = (image),
            contentDescription = null,
        )
        TextHere(main = main, sub = sub, modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AplikacjaCzwartaTheme {
        ImageWithText(stringResource(id = R.string.main), stringResource(id = R.string.sub_text), modifier = Modifier)
    }
}
