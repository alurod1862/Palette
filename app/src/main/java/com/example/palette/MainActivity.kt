package com.example.palette

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.palette.ui.theme.MyTopAppBar
import com.example.palette.ui.theme.PaletteTheme
import com.example.palette.ui.theme.ciudadSeleccionada
import com.example.palette.ui.theme.portada


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaletteTheme {
                val navController = rememberNavController()
                Scaffold(

                    topBar = { MyTopAppBar("Ciudad/{nombreCiudad}") },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                      navController.navigate("Portada")
                            },
                            content = {
                                Icon(Icons.Filled.ArrowBack, contentDescription = "Agregar")
                            },
                            containerColor = Color(0xFF6AB7FF)
                        )
                    },
                    floatingActionButtonPosition = FabPosition.End,
                ) {
                    NavHost(navController = navController, startDestination = "Portada") {
                        composable("Portada") { portada(navController) }
                        composable("Ciudad/{nombreCiudad}") { backStackEntry ->
                            val nombreCiudad = backStackEntry.arguments?.getString("nombreCiudad")
                            ciudadSeleccionada(nombreCiudad)
                        }
                    }
                }
            }
        }
    }

}

