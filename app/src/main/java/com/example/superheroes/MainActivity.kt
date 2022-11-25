package com.example.superheroes

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.datasource.superHeroList
import com.example.superheroes.model.SuperHero
import com.example.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroScreen()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SuperHeroScreen() {
    androidx.compose.material.Scaffold(topBar = {
        SuperHeroAppBar()
    }) {
   LazyColumn(
       modifier = Modifier
           .background(MaterialTheme.colorScheme.surface)) {
       items(superHeroList) {
           SuperHeroes(superHeroItem = it)
       }
   }
    }
}

@Composable
fun SuperHeroes(superHeroItem: SuperHero) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 16.dp,
            end = 16.dp,
            top = 8.dp,
            bottom = 8.dp)

    ) {

        Row {
            SuperHeroInfo(superHeroName = superHeroItem.name, superHeroAbility = superHeroItem.ability, modifier = Modifier.weight(0.6f))
            SuperHeroIcon(
                superHeroImage = superHeroItem.icon,
                superHeroContentDesc = superHeroItem.name,
                Modifier.weight(0.4f)
            )

        }
    }
}



    @Composable
    fun SuperHeroAppBar() {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        }
    }

    @Composable
    fun SuperHeroInfo(
        modifier: Modifier = Modifier,
        @StringRes superHeroName: Int = R.string.iron_man,
        @StringRes superHeroAbility: Int = R.string.iron_man_ability,
    ) {
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = superHeroName),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify,
            )
            Text(
                text = stringResource(id = superHeroAbility),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify,
            )

        }
    }

    @Composable
    fun SuperHeroIcon(
        @DrawableRes superHeroImage: Int,
        @StringRes superHeroContentDesc: Int,
        modifier: Modifier = Modifier
    ) {
        Image(
            painter = painterResource(id = superHeroImage),
            contentDescription = stringResource(id = superHeroContentDesc),
            modifier = modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        SuperHeroesTheme {
            SuperHeroScreen()
        }
    }

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview1() {
    SuperHeroesTheme {
        SuperHeroScreen()
    }
}