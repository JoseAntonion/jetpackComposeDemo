package com.example.democompose.model

import com.example.democompose.model.MediaItem.Type

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
) {
    enum class Type {
        PHOTO, VIDEO
    }
}

fun getMedia() = (1..10).map {
    MediaItem(
        id = it,
        title = "Elemento $it",
        thumb = "https://picsum.photos/640/360",
        type = if (it % 3 == 0) Type.VIDEO else Type.PHOTO
    )
}
