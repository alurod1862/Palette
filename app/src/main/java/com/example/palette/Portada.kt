package com.example.palette

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.palette.graphics.Palette


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun portada(navController: NavController) {
    Column {
        Spacer(modifier = Modifier.height(65.dp))

        val items3 = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
        )

        val items = listOf(
            "Muchisimas flores",
            "Desierto",
            "Flor",
            "Medusa",
            "Muchas Flores",
            "Castilo",
            "Pinguino",
            "Flores",
        )

        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
            items(items3.size) { index ->
                Box(
                    modifier = Modifier.padding(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = items3[index]),
                        contentDescription = "1",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("Ciudad/${items[index]}")
                            },
                        contentScale = ContentScale.Crop,
                    )
                    TopAppBar(
                        title = { Text(items[index], color = Color.White, textDecoration = TextDecoration.Underline) },
                    )
                }
            }
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ciudadSeleccionada(nombreCiudad: String?) {

    val imagenId = when (nombreCiudad) {
        "Muchisimas flores" -> R.drawable.image1
        "Desierto" -> R.drawable.image2
        "Flor" -> R.drawable.image3
        "Medusa" -> R.drawable.image4
        "Muchas Flores" -> R.drawable.image5
        "Castilo" -> R.drawable.image6
        "Pinguino" -> R.drawable.image7
        "Flores" -> R.drawable.image8
        else -> R.drawable.image1
    }


    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(id = imagenId),
            contentDescription = "1",
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            contentScale = ContentScale.Crop,
        )

        val context = LocalContext.current

        val bitmap = remember {
            BitmapFactory.decodeResource(context.resources, imagenId)
        }

        val palette = remember {
            Palette.from(bitmap).generate()
        }



        val lightVibrant = palette.lightVibrantSwatch

        val darkVibrant = palette.darkVibrantSwatch

        val lightMuted = palette.lightMutedSwatch

        val muted = palette.mutedSwatch

        val darkMuted = palette.darkMutedSwatch


            Row(
                modifier = Modifier
                    .background(lightVibrant?.let { Color(it.rgb) }
                        ?: Color.Red)
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Light Vibrant",
                    color = lightVibrant?.let { Color(it.titleTextColor) } ?: Color.White,
                )
            }

            Row(
                modifier = Modifier
                    .background(darkVibrant?.let { Color(it.rgb) }
                        ?: Color.Red)
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dark Vibrant",
                    color = darkVibrant?.let { Color(it.titleTextColor) } ?: Color.White
                )
            }

            Row(
                modifier = Modifier
                    .background(lightMuted?.let { Color(it.rgb) }
                        ?: Color.Red)
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Light Muted",
                    color = lightMuted?.let { Color(it.titleTextColor) } ?: Color.White
                )
            }

            Row(
                modifier = Modifier
                    .background(muted?.let { Color(it.rgb) }
                        ?: Color.Red)
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Muted",
                    color = muted?.let { Color(it.titleTextColor) } ?: Color.White
                )
            }

            Row(
                modifier = Modifier
                    .background(darkMuted?.let { Color(it.rgb) }
                        ?: Color.Red)
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dark Muted",
                    color = darkMuted?.let { Color(it.titleTextColor) } ?: Color.White
                )
            }
        }


}


    