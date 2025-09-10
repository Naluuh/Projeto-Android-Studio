
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DisciplinasApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview (showBackground = true)

@Composable
fun DisciplinasApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Disciplinas", fontSize = 20.sp) }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Text("Aulas Online", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(Modifier.height(8.dp))
            }

            items(
                listOf(
                    "Big data",
                    "Computação paralela e distribuída",
                    "Gestão estratégica de negócios"
                )
            ) { disciplina ->
                DisciplineCard(
                    disciplina = disciplina,
                    tipo = "Disciplina online",
                    icon = Icons.Outlined.Computer // 💻
                )
            }

            item {
                Spacer(Modifier.height(16.dp))
                Text("Aulas Presenciais", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(Modifier.height(8.dp))
            }

            items(
                listOf(
                    "Ti e sociedade",
                    "Data science",
                    "Desenvolvimento de aplicativos\nmóveis",
                    "Arquitetura de software"
                )
            ) { disciplina ->
                DisciplineCard(
                    disciplina = disciplina,
                    tipo = "",
                    icon = Icons.Outlined.MenuBook // 📘
                )
            }
        }
    }
}

@Composable
fun DisciplineCard(disciplina: String, tipo: String, icon: ImageVector) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(end = 12.dp)
                )
                Column {
                    Text(disciplina, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    Text(tipo, fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight, // ➡️
                contentDescription = "Abrir disciplina"
            )
        }
    }
}