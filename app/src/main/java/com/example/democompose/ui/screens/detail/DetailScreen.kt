package com.example.democompose.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.example.democompose.model.getMedia
import com.example.democompose.ui.MyComposeTheme
import com.example.democompose.ui.screens.common.Thumb

@ExperimentalCoilApi
@Composable
//@Preview(showBackground = true)
fun DetailScreen(mediaId: Int) {
    val mediaItem = remember { getMedia().first { it.id == mediaId } }
    MyComposeTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = mediaItem.title) }) }
        ) { padding ->
            Thumb(
                item = mediaItem,
                modifier = Modifier.padding(padding)
            )
        }
    }
}