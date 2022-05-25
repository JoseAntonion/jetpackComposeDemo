package com.example.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.democompose.ui.screens.detail.DetailScreen
import com.example.democompose.ui.screens.main.MainScreen
import com.example.democompose.ui.screens.main.MediaListColumn
import com.example.democompose.ui.theme.DemoComposeTheme

@ExperimentalCoilApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // TODO: ==== T h e m a s ====
            //MaterialTheme(
            //    colors = lightColors(),
            //    typography = Typography,
            //    shapes = Shapes
            //) {

            // TODO: ==== N A V E G A C I O N ====
            val navController = rememberNavController()
            NavHost(// Define el grafo de navegacion
                navController = navController,
                startDestination = "main"
            ) { //Define grafo de navegacion
                composable("main") {
                    MainScreen(navController)
                }

                // ==== Pasar argumentos entre navegaciones ====
//                detail/{mediaId} ------> parametro obligatiorio
//                detail?mediaId={mediaId} ------> parametro opcional
                composable(
                    route = "detail/{mediaId}",
                    arguments = listOf(
                        navArgument("mediaId") { type = NavType.IntType }
                    )// Permite configurar tipo de dato del argumento. Por defecto es String
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("mediaId")
                    requireNotNull(id) { "No puede ser nulo" }
                    DetailScreen(id)
                }
            }

            //MyComposeTheme {
            // TODO: ====   C O M P O N E N T E S  ====
            //Greeting("Compose")
            //ButtonText()
            //MediaItem()
            //MediaListColumn()
            //MediaListRow()
            //MediaListGrid()
            //MainScreen()

            // TODO: ====   E S T A D O S   ====
            // Variable estado normal. Se accede a su valor con text.value
            var textVariable = remember { mutableStateOf("") }

            // Propiedad de estado. No es necesario acceder con text.value
            var textProperty by remember { mutableStateOf("") }

            // SuperESTADO
            // var (getter, setter) = ...
            //val (value, onValueChange) = rememberSaveable { mutableStateOf("") }// crea la variable solo una vez y la guarda cuando se recrea el activity (ej. cuando se rota la pantalla)
            //StateSample(
            //    value = value,
            //    onValueChange = onValueChange
            //)

        }
    }
}

//@Preview(showBackground = true, widthDp = 400, heightDp = 400)
// Cuando se envian valores por parametro, no se permite generar preview
@Composable
fun StateSample(value: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        Button(
            onClick = { onValueChange("") },
            enabled = value.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Clear")
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) { // Modifier debe ser el primer parametro opcional
    Text(text = "Hola $name!", modifier = modifier)
}

@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun NewButtonText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hola Mochila",
            color = Color.Red,
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold, // configuracion para Negrita (configura el ancho de la letra)
            fontFamily = FontFamily.Monospace,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.LineThrough,
            lineHeight = 2.em, // Interlineado (em es el tamaño de una M, en este caso, 2 emes)
            softWrap = true, // termina la linea con una palabra, no una letra (EJ: el avion desa-parecio)
            overflow = TextOverflow.Ellipsis, // agrega ... cuando llega al final de la linea
            // onTextLayout = x       =========> Listener que retorna la info del texto
            style = MaterialTheme.typography.h4.copy( // Copy es para modificar opciones del Style
                shadow = Shadow(
                    offset = Offset(10f, 10f),
                    blurRadius = 10f
                )
            )       //=========> Agrega estilo predefinido
        )
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun ButtonText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hola Mochila",
            modifier = Modifier // Dependiendo del orden de los modifier, es como se aplican a la vista
                .clickable { /* TODO */ }
                .background(Color.Cyan)
                .border(width = 2.dp, color = Color.Blue)
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )// En compose solo existe el padding
        )
    }
}

@Preview(
    showBackground = true,
    name = "Compose Demo",
    widthDp = 400,
    heightDp = 200
)
@Composable
fun DefaultPreview() {
    DemoComposeTheme {
        Column(
// ROW funciona de la misma manera, pero con horizontalArrangement y verticalAlignment
            modifier = Modifier.fillMaxSize(),
            //verticalArrangement = Arrangement.SpaceEvenly, // Distribucíon de elementos en la columna
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting(
                name = "Android",
                modifier = Modifier
                    .background(Color.Green)
                    .weight(1f)
            )
            Greeting(
                name = "Mundillo",
                modifier = Modifier
                    .background(Color.Magenta)
                    .weight(2f)
            )
            Greeting(
                name = "Mochila",
                modifier = Modifier
                    .background(Color.Cyan)
                    .weight(3f)
            )
        }
    }
}
