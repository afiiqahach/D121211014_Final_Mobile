package com.D121211014.harrypotterapp.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211014.harrypotterapp.data.models.Character
import com.D121211014.harrypotterapp.ui.activities.detail.DetailActivity
import com.D121211014.harrypotterapp.ui.theme.HarryPotterTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarryPotterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CenterAlignedTopAppBar(modifier = Modifier.background(Color.LightGray),
                            title = {
                                Text(
                                    text = "HARRY POTTER CAST",
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        )
                        val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                        ListHarryPotterScreen(mainViewModel.mainUiState)
                    }
                }
            }
        }
    }

    @Composable
    private fun ListHarryPotterScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState){
            is MainUiState.Loading -> Text(text = "Loading...", fontSize = 20.sp)
            is MainUiState.Error -> Text(text = "Error", fontSize = 20.sp)
            is MainUiState.Success -> HarryPotterList(mainUiState.character)
        }
    }

    @Composable
    fun HarryPotterList(character: List<Character>, modifier: Modifier = Modifier) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(
                items = character
            ) {
                character ->
                CharacterItem(character = character, modifier = Modifier.fillMaxSize())
            }
        }
    }

    @Composable
    fun CharacterItem(character: Character, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .padding(25.dp)
                .border(5.dp, Color.Red, RoundedCornerShape(15.dp),)
                .size(width = 30.dp, height = 350.dp)
                .clickable {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("CHARACTER", character)
                    startActivity(intent)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)

            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(character.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = character.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = character.name.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = character.house.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = character.yearOfBirth.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}


//override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            HarryPotterTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
//                    ListHarryPotterScreen(mainViewModel.mainUiState)
//                }
//            }
//        }
//    }
//
//    @Composable
//    private fun ListHarryPotterScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
//        when (mainUiState) {
//            is MainUiState.Loading -> Text(text = "Loading...", fontSize = 16.sp)
//            is MainUiState.Error -> Text(text = "Error", fontSize = 16.sp)
//            is MainUiState.Success -> ListHarryPotter(mainUiState.character)
//        }
//    }
//
//    @Composable
//    private fun ListHarryPotter(character: List<Character>, modifier: Modifier = Modifier) {
//        LazyColumn(modifier = modifier) {
//            items(character) {character ->
//                CharacterItem(character = character)
//            }
//        }
//    }
//
//    @Composable
//    fun CharacterItem(character: Character) {
//        Box(modifier = Modifier
//            .padding(16.dp)
//            .border(1.dp, Color.Blue, RoundedCornerShape(8.dp),)
//            .clickable {
//                val intent = Intent(this, DetailActivity::class.java)
//                intent.putExtra("CHARACTER", character)
//                startActivity(intent)
//            }
//        ) {
//            Column (
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//
//            ) {
//                AsyncImage(
//                    model = ImageRequest.Builder(context = LocalContext.current)
//                        .data(character.image)
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = character.name,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp)
//                        .clip(MaterialTheme.shapes.medium),
//                    contentScale = ContentScale.Crop
//                )
//
//                // detail karakter
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = character.name.toString(),
//                    style = MaterialTheme.typography.headlineSmall,
//                    fontWeight = FontWeight.Bold
//                    )
//
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = character.id.toString(),
//                    style = MaterialTheme.typography.bodySmall
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = character.dateOfBirth.toString(),
//                    style = MaterialTheme.typography.bodySmall
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = character.dateOfBirth.toString(),
//                    style = MaterialTheme.typography.bodySmall
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = character.actor.toString(),
//                    style = MaterialTheme.typography.bodySmall
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = character.ancestry.toString(),
//                    style = MaterialTheme.typography.bodySmall
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = character.eyeColour.toString(),
//                    style = MaterialTheme.typography.bodySmall
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = character.ancestry.toString(),
//                    style = MaterialTheme.typography.bodySmall
//                )
//            }
//        }
//    }