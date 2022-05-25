package com.example.democompose.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.democompose.ui.MyComposeTheme

@ExperimentalFoundationApi
//@Preview
@Composable
fun MainScreen(navController: NavHostController) {
    MyComposeTheme {
        Scaffold(topBar = { MainAppBar() })
        { padding -> // Siempre se debe agregar este padding al primer elemento del Scaffold
            MediaListGrid(
                navController,
                modifier = Modifier.padding(padding)
            )
        }
    }
}