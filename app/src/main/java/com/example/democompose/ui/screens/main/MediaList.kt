package com.example.democompose.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.democompose.R
import com.example.democompose.model.getMedia

@Preview(showBackground = true)
@Composable
fun MediaListColumn() {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.pding_l)),// padding derecho/izquierdo
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.pding_l))
    ) {
        items(getMedia()) { item ->
            MediaListItem(item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediaListRow() {
    LazyRow(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.pding_l)),// padding derecho/izquierdo
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.pding_l))
    ) {
        items(getMedia()) { item ->
            MediaListItemRow(item)
        }
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
//@Preview(showBackground = true)
@Composable
fun MediaListGrid(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.pding_s)),// padding derecho/izquierdo
        //cells = GridCells.Fixed(2)// Tamaño fijo de celdas
        cells = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_weigth)),// Tamaño se adapta a la pantalla con un minimo de 150 por item
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaListItemRow(
                item = item,
                navController,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.pding_m))
            )
        }
    }
}