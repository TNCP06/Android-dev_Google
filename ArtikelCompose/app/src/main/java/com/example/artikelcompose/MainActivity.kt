package com.example.artikelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artikelcompose.ui.theme.ArtikelComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtikelComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LandingPage()
                }
            }
        }
    }
}

@Composable
fun HeaderImage() {
    Image(
        painterResource(id = R.drawable.bg_compose_background),
        contentDescription = null
    )
}

@Composable
fun Text(textAlign: TextAlign, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.landing_page_title),
        fontSize = 24.sp,
        modifier = modifier
    )
    Text(
        text = stringResource(R.string.landing_page_content),
        textAlign = textAlign,
        modifier = modifier
            .padding(bottom = 0.dp, top = 0.dp)
    )
    Text(
        text = stringResource(R.string.landing_page_content_2),
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun LandingPage() {
    Column {
        HeaderImage()
        Text(
            textAlign = TextAlign.Justify,
            Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun GreetingPreview() {
    ArtikelComposeTheme {
        LandingPage()
    }
}