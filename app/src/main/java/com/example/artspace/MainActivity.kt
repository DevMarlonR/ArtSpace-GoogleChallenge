package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        ImagePrincipal()
        ImageDescription()
        NavigationButtons()
    }
}

@Composable
fun ImagePrincipal(
    image: Int = R.drawable.cristo_redentor_rj,
    modifier: Modifier = Modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .shadow(2.dp, spotColor = Color.DarkGray)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(16.dp)
            )
        }
}

@Composable
fun ImageDescription(modifier: Modifier = Modifier) {
    val artTitle = "Still Life of Blue Rose and"
    val artistName = "Njoe"
    val artYear = "2022"
    Column (
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Text(
            text = artTitle,
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W300
        )
        Row {
            Text(
                text = artistName,
                fontWeight = FontWeight.W500
            )
            Text(
                text = " ($artYear)",
                fontWeight = FontWeight.W200
            )
        }
    }
}

@Composable
fun NavigationButtons(
    modifier: Modifier = Modifier) {
    Row {
        Button(
            onClick = {

            },
            modifier = Modifier
                .width(180.dp)
                .padding(8.dp)
        ) {Text(text = "Previous")}
        Button(onClick = {

        },
            modifier = Modifier
                .width(180.dp)
                .padding(8.dp)
        ) {Text(text = "Next")}
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}