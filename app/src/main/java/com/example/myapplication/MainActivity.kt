package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFF5F7FA)
            ) {
                TelaInicial()
            }
        }
    }
}

@Composable
fun TelaInicial() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Topo()
        Saudacao()
        CartaoCurso()
        BotoesSecao()
        CentralAjuda()
        Spacer(modifier = Modifier.weight(1f))
        MenuInferior()
    }
}

@Composable
fun Topo() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Usuário",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun Saudacao() {
    Text(
        text = "Olá, Nalu :)",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

@Composable
fun CartaoCurso() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF103D79), shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Superior de Tecnologia em\nAnálise e Desenvolvimento de Sistemas",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "RGM 37481096",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "CURSANDO",
            color = Color(0xFF103D79),
            fontSize = 12.sp,
            modifier = Modifier
                .padding(top = 8.dp)
                .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun BotoesSecao() {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(text = "Ambiente Virtual", color = Color.White)
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBBDEFB)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Horários de Aulas", color = Color(0xFF103D79))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CentralAjuda() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "CENTRAL DE AJUDA",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        var textoBusca by remember { mutableStateOf("") }

        OutlinedTextField(
            value = textoBusca,
            onValueChange = { textoBusca = it },
            placeholder = { Text("Procurar no app") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Buscar")
            }
        )
    }
}

@Composable
fun MenuInferior() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.Home, contentDescription = "Início", tint = Color.Gray)
        Icon(imageVector = Icons.Default.School, contentDescription = "Meu Curso", tint = Color.Gray)
        Icon(imageVector = Icons.Default.AttachMoney, contentDescription = "Financeiro", tint = Color.Gray)
        Icon(imageVector = Icons.Default.Person, contentDescription = "Perfil", tint = Color.Gray)
    }
}
