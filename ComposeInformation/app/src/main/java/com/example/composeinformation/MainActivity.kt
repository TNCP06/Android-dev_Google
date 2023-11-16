package com.example.composeinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeinformation.ui.theme.ComposeInformationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeInformationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InformationPage()
                }
            }
        }
    }
}

@Composable
fun InformationPage(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Row(modifier.weight(1f)) {
            // Kuadran 1 (Text Composable)
            ComposeBox(
                stringResource(R.string.text_title),
                stringResource(R.string.text_content),
                Color(0xFFEADDFF),
                modifier.weight(1f)
            )
            // Kuadran 2 (Image Composable)
            ComposeBox(
                stringResource(R.string.image_title),
                stringResource(R.string.image_content),
                Color(0xFFD0BCFF),
                modifier.weight(1f)
            )
        }
        Row(modifier.weight(1f)) {
            // Kuadran 3 (Row Composable)
            ComposeBox(
                stringResource(R.string.row_title),
                stringResource(R.string.row_content),
                Color(0xFFB69DF8),
                modifier.weight(1f)
            )
            // Kuadran 4 (Column Composable)
            ComposeBox(
                stringResource(R.string.column_title),
                stringResource(R.string.column_content),
                Color(0xFFF6EDFF),
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposeBox(
    title: String,
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
// not recommend in using modifier instead of Modifier
// cause it will read that it just a parameter not a class
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeInformationTheme {
        InformationPage()
    }
}