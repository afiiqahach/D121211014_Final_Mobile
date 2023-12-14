package com.D121211014.harrypotterapp.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211014.harrypotterapp.data.models.Character
import com.D121211014.harrypotterapp.ui.theme.HarryPotterTheme

class DetailActivity : ComponentActivity() {

    private var selectedCharacter: Character? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedCharacter = intent.getParcelableExtra("CHARACTER")
        setContent {
            HarryPotterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    fun DetailScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(selectedCharacter?.image)
                    .crossfade(true)
                    .build(),
                contentDescription = selectedCharacter?.name,
                modifier = Modifier
                    .width(400.dp)
                    .height(600.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            // character details
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedCharacter?.name ?: "unknown",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.alternate_names ?: "unknown"}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.species.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.gender.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.house.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.dateOfBirth.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.yearOfBirth.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.wizard.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.ancestry.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.eyeColour.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.hairColour.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.wand.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alternate Names : ${selectedCharacter?.patronus.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedCharacter?.hogwartsStudent.toString(),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Actor : ${selectedCharacter?.actor.toString()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedCharacter?.hogwartsStaff.toString(),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedCharacter?.alternate_actors.toString(),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedCharacter?.alive.toString(),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}


