package com.example.democompose.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.example.democompose.model.MediaItem

@ExperimentalCoilApi
@Composable
fun Thumb(item: MediaItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberImagePainter(
                data = item.thumb,
                builder = {
                    transformations(RoundedCornersTransformation())//LocalContext.current para obtener contexto en cualquier composable
                    //transformations(BlurTransformation(LocalContext.current))//LocalContext.current para obtener contexto en cualquier composable
                    //transformations(CircleCropTransformation())
                    //crossfade(true) //efecto antes de la carga de la imagen
                }
            ),
            contentDescription = "item compose",// Para que las personas que no pueden ver, puedan escucharlo
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (item.type == MediaItem.Type.VIDEO) {
            Icon(
                imageVector = Icons.Outlined.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier.size(92.dp),
                tint = Color.White,
            )
        }
        // Para poder usar Icon con drawables
        //Icon(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
    }
}