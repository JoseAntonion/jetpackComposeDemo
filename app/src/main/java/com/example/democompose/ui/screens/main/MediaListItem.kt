package com.example.democompose.ui.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.democompose.model.MediaItem
import com.example.democompose.ui.screens.common.Thumb

//@Preview
@Composable
fun MediaListItem(item: MediaItem) {
    Column {
        Thumb(item)
        Title(item)
    }
}

//@Preview(showBackground = true)
@ExperimentalCoilApi
@Composable
fun MediaListItemRow(
    item: MediaItem,
    navController: NavHostController? = null,
    modifier: Modifier = Modifier
) {
    // TODO: TARJETAS
    Card(
        modifier = modifier
            .clickable { navController?.navigate("detail/${item.id}") },
        elevation = 0.dp,
        border = BorderStroke(1.dp, Color.LightGray),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.secondary
        //shape = RoundedCornerShape(4.dp)
    ) {
        Column {
            Thumb(item)
            Title(item)
        }
    }
}

@Composable
fun Title(item: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.background(MaterialTheme.colors.secondary)
            .padding(16.dp)
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.h6
        )
    }
}