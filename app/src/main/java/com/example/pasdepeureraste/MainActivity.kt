package com.example.pasdepeureraste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pasdepeureraste.ui.theme.PasDePeurErasteTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasDePeurErasteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val persons = mutableListOf<Person>()
    (1..2000).forEach {
        persons.add(Person(name = "Name $it", age = Random.nextInt(1, 50)))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.shadow(elevation = 10.dp, shape = CircleShape).size(150.dp),
            painter = painterResource(id = R.drawable.man),
            contentDescription = ""
        )
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray), content = {
            items(persons) { person ->
                PersonRow(person)
            }
        })

    }
}


@Composable
fun PersonRow(person: Person) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
            Spacer(modifier = Modifier.width(30.dp))
            Column {
                Text(text = person.name, fontSize = 20.sp)
                Text(text = "Age: ${person.age} an${if (person.age > 1) "s" else ""}")
            }
        }
    }
    Divider()
}

class Person(var name: String, var age: Int)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PasDePeurErasteTheme {
        Greeting("Android")
    }
}