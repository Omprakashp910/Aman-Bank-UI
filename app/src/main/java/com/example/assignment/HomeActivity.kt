package com.example.assignment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                HomeScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Menu Icon",
                            modifier = Modifier
                                .size(40.dp)
                                .padding(8.dp)
                        )
                        Spacer(modifier = Modifier.width(13.dp))
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .height(80.dp)
                        )

                    }

                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF003366)
                ),
                navigationIcon = {

                }
            )
        }
        ,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.mscreen),
                    contentDescription = null,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Welcome to Aman Bank",
                    fontSize = 21.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold

                )


                Spacer(modifier = Modifier.height(16.dp))
                   GridMenu()

                Card(
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF003559),
                    ),
                    modifier = Modifier.padding(top=30.dp)
                        .fillMaxWidth(1f)
                        .height(180.dp)


                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.chat),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.TopEnd)
                                .padding(end = 10.dp)
                        )


                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize()
                        ) {
                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFF5F5F5),
                                    contentColor = Color(0xFF0B73D5)
                                ),
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 16.dp)
                                    .height(50.dp)
                            ) {
                                Text(
                                    text = "Log In",
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun GridMenu(modifier: Modifier = Modifier.padding(6.dp)) {
    val items = listOf(
        "Account Details" to R.drawable.h1,
        "Recent Transactions" to R.drawable.rtrans,
        "Card Details" to R.drawable.cc,
        "Locate ATM" to R.drawable.atm,
        "Locate Branch" to R.drawable.bank,
        "Open Account" to R.drawable.act
    )

    Column(
        modifier = modifier
    ) {
        items.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 1.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowItems.forEach { (label, icon) ->
                    MenuItem(label = label, iconRes = icon)
                }
            }
        }
    }
}

@Composable
fun MenuItem(label: String, iconRes: Int) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .padding(6.dp)
            .border(0.3.dp, Color(0xFFcadff4), RoundedCornerShape(12.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = label,
            fontSize = 15.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
        )
    }
}
