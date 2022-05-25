package com.example.democompose.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.democompose.ui.theme.DemoComposeTheme

@Composable
fun MyComposeTheme(content: @Composable () -> Unit) {
    DemoComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}