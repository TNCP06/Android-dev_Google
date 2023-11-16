package com.example.namecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namecard.ui.theme.NameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NameCardPage()
                }
            }
        }
    }
}

@Composable
fun NameCardPage() {
    Column(
        modifier = Modifier.background(Color(210, 232, 212, 255)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Appearance()
    }

// 2 ways to place this Contact layout at the bottom center which are with
// (Box container & contentAlignment) or (wrapContentWidth & verticalArrangement)
//    Box(
//        modifier = Modifier.padding(bottom = 40.dp),
//        contentAlignment = Alignment.BottomCenter
//    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 40.dp)
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Contact(
                id = R.string.contact_phone,
                icon = Icons.Rounded.Phone,
                talkBack = "The phone number is"
            )
            Contact(
                id = R.string.contact_instagram,
                icon = Icons.Rounded.Share,
                talkBack = "The social media account is"
            )
            Contact(
                id = R.string.contact_email,
                icon = Icons.Rounded.Email,
                talkBack = "The email is"
            )
        }
    }
//}

@Composable
fun Appearance() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 90.dp)
    ) {
        AndroidLogo()
        Text(
            text = stringResource(R.string.name_profile),
            color = Color(11,20,14,255),
            fontSize = 28.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(R.string.description_profile),
            color = Color(1,109,59,255),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun AndroidLogo() {
            Image(
                painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .background(Color(7, 48, 66))
                    .padding(
                        vertical = 16.dp,
                        horizontal = 8.dp
                    )
            )
}

@Composable
fun Contact(
    color: Color = Color(1,109,59,255),
    icon: ImageVector, id: Int, talkBack: String
) {
    Row(
        modifier = Modifier.padding(4.dp)
    ) {
        val contactText = stringResource(id)
        Icon(
            imageVector = icon,
            contentDescription = "$talkBack $contactText",
            tint = color,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = contactText
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    NameCardTheme {
        NameCardPage()
    }
}