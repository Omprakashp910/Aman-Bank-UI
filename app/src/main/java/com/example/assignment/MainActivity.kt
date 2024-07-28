package com.example.assignment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import kotlinx.coroutines.delay



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash") {
                composable("splash") { SplashScreen(navController) }
                composable("main") { MainScreen(navController) }
                composable("home") { HomeScreen() }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("main") { MainScreen(navController) }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate("main") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF003366)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(0.4f)
            )
            Text(
                text = "Secured by Aman Bank",
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navigateToHome: NavHostController) {
    val pagerState = rememberPagerState { 2 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF003366)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth().padding(top = 50.dp),
        ) { page ->
            when (page) {
                0 -> SlideContent(
                    logoResId = R.drawable.logo,
                    illustrationResId = R.drawable.illustration2,
                    title = "Welcome to Amanbanks",
                    subtitle = "Your best selection for financial transaction.",
                )

                1 -> SlideContent(
                    logoResId = R.drawable.logo,
                    illustrationResId = R.drawable.illustration3,
                    title = "Manage your Finance",
                    subtitle = "Your finances at your fingertips."
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            repeat(2) { pageIndex ->
                val color = if (pagerState.currentPage == pageIndex) Color(0xFF1379CA) else Color(
                    0xFFBDB8B8
                )
                Box(
                    modifier = Modifier
                        .size(35.dp, 13.dp)
                        .padding(4.dp)
                        .background(color, shape = RoundedCornerShape(4.dp))
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFFF5F5F5),
                        containerColor = Color(0xFF0B73D5)
                    ),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .padding(top = 45.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Log In",
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                LineWithText()

                Spacer(modifier = Modifier.height(8.dp))
                val CustomColor = Color(0xFF003559)
                Text(
                    text = "Go to Home Page",
                    color = CustomColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { navigateToHome.navigate("home") }
                )
                TextWithUnderline()
            }
        }
    }
}


@Composable
fun SlideContent(
    logoResId: Int,
    illustrationResId: Int,
    title: String,
    subtitle: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = logoResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = illustrationResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 32.dp).padding(top = 15.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = title,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = subtitle,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}}


