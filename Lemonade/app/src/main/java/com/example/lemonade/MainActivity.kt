package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadePreview()
                }
            }
        }
    }
}

@Composable
fun LemonApp() {
    var clickCounter by remember { mutableStateOf(0) }
    var pageCounter by remember { mutableStateOf(2) }
    var stopper by remember { mutableStateOf((2..4).random()) }

    var contentDescription by remember { mutableStateOf(R.string.lemon_tree_content_description) }
    var img by remember { mutableStateOf(R.drawable.lemon_tree) }
    var description by remember { mutableStateOf(R.string.lemon_tree_description) }

    Image(
        painterResource(id = img),
        contentDescription = stringResource(contentDescription),
        modifier = Modifier
            .background(
                color = Color(196, 236, 210, 255),
                shape = RoundedCornerShape(32.dp)
            )
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .clickable {
                when (pageCounter) {
                    1 -> {
                        contentDescription = R.string.lemon_tree_content_description
                        img = R.drawable.lemon_tree
                        description = R.string.lemon_tree_description
                        pageCounter++
                    }

                    2 -> {
                        contentDescription = R.string.lemon_content_description
                        img = R.drawable.lemon_squeeze
                        description = R.string.lemon_description
                        clickCounter++
                        if (clickCounter == stopper) {
                            stopper = (2..4).random()
                            clickCounter = 0
                            pageCounter++
                        }
                    }

                    3 -> {
                        contentDescription = R.string.lemon_drink_content_description
                        img = R.drawable.lemon_drink
                        description = R.string.lemon_drink_description
                        pageCounter++
                    }

                    4 -> {
                        contentDescription = R.string.empty_glass_content_description
                        img = R.drawable.lemon_restart
                        description = R.string.empty_glass_description
                        pageCounter = 1
                    }

                    else -> {
                        pageCounter = 1
                    }
                }
            }
    )
    Spacer(modifier = Modifier.size(16.dp))
    Text(
        text = stringResource(description),
        fontSize = 18.sp,
        color = Color.Black
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(color = Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color(249, 228, 75, 255))
                    .fillMaxWidth(1f)
            ) {
                Text(
                    text = "Lemonade",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 48.dp, bottom = 16.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                LemonApp()
            }
        }
    }
}