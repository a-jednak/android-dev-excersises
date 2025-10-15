package com.example.aplikacjatrzecia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplikacjatrzecia.ui.theme.AplikacjaTrzeciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplikacjaTrzeciaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageWithInfo(
                        title = stringResource(R.string.title),
                        firstline = stringResource(R.string.line_one),
                        secondline = stringResource(R.string.line_two),
                        modifier = Modifier.padding(innerPadding) // 16.dp ?
                    )
                }
            }
        }
    }
}

@Composable
fun Information(title: String, firstline: String, secondline: String, modifier: Modifier = Modifier)
{
    Column {
        Text( // tytul
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = firstline,
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = secondline,
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ImageWithInfo(title: String, firstline: String, secondline: String, modifier: Modifier = Modifier)
{
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = (image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Information(title = title, firstline = firstline, secondline = secondline,)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AplikacjaTrzeciaTheme {
        ImageWithInfo( title = stringResource(R.string.title),
            firstline = stringResource(R.string.line_one),
            secondline = stringResource(R.string.line_two))

    }
}