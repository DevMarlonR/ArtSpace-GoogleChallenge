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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun ArtSpaceApp(
    modifier: Modifier = Modifier
) {
    var imageCount by remember { mutableStateOf(1) }

    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        when (imageCount) {
            1 -> {
                ImagePrincipal(
                    image = R.drawable.cristo_redentor_rj,
                    description = stringResource(R.string.description_1)
                )
                ImageDescription(
                    artTitle = stringResource(R.string.description_1),
                    artistName = stringResource(R.string.cidade_1),
                    artYear = stringResource(R.string.ano_lancamento_1)
                )
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            imageCount = 4
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .padding(8.dp)
                    ) {Text(text = "Previous")}
                    Button(
                        onClick = {
                            imageCount = 2
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .padding(8.dp)
                    ) {Text(text = "Next")}
                }
            }
            2 -> {
                ImagePrincipal(
                    image = R.drawable.beto_carrero_world,
                    description = stringResource(R.string.description_2)
                )
                ImageDescription(
                    artTitle = stringResource(R.string.description_2),
                    artistName = stringResource(R.string.cidade_2),
                    artYear = stringResource(R.string.ano_lancamento_2)
                )
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            imageCount = 1
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .padding(8.dp)
                    ) {Text(text = "Previous")}
                    Button(
                        onClick = {
                            imageCount = 3
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .padding(8.dp)
                    ) {Text(text = "Next")}
                }
            }
            3 -> {
                ImagePrincipal(
                    image = R.drawable.jardim_botanico_curitiba,
                    description = stringResource(R.string.description_3)
                )
                ImageDescription(
                    artTitle = stringResource(R.string.description_3),
                    artistName = stringResource(R.string.cidade_3),
                    artYear = stringResource(R.string.ano_lancamento_3)
                )
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            imageCount = 2
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .padding(8.dp)
                    ) {Text(text = "Previous")}
                    Button(
                        onClick = {
                            imageCount = 4
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .padding(8.dp)
                    ) {Text(text = "Next")}
                }
            }
            else -> {
                ImagePrincipal(
                    image = R.drawable.cataratas_do_iguacu,
                    description = stringResource(R.string.description_4).toString()
                )
                ImageDescription(
                    artTitle = stringResource(R.string.description_4),
                    artistName = stringResource(R.string.cidade_4),
                    artYear = stringResource(R.string.ano_lancamento_4)
                )
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            imageCount = 3
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .padding(8.dp)
                    ) {Text(text = "Previous")}
                    Button(
                        onClick = {
                            imageCount = 1
                        },
                        modifier = Modifier
                            .width(180.dp)
                            .padding(8.dp)
                    ) {Text(text = "Next")}
                }
            }

        }

    }
}

@Composable
fun ImagePrincipal(
    image: Int,
    description: String = "",
    modifier: Modifier = Modifier
) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(500.dp)
                .width(640.dp)
                .shadow(2.dp, spotColor = Color.DarkGray)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = description,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(16.dp)
            )
        }
}

@Composable
fun ImageDescription(
    artTitle: String,
    artistName: String,
    artYear: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier
            .background(color = Color.LightGray)
            .width(640.dp)
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

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}