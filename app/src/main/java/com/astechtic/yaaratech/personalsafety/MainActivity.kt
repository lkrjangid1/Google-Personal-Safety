package com.astechtic.yaaratech.personalsafety

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.astechtic.yaaratech.personalsafety.ui.theme.PersonalSafetyTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalSafetyTheme(
                darkTheme = true,
            ) {
                ScaffoldComposeFunc()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComposeFunc() {
    Scaffold(
        containerColor = colorScheme.background,
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
            ) {
                Icon(
                    Icons.Outlined.Settings, "Settings", modifier = Modifier.size(30.dp)
                )
                Text(
                    "Personal Safety", fontSize = 20.sp
                )
                Image(
//                    painter = painterResource(R.drawable.ic_launcher_background),
                    painter = rememberAsyncImagePainter("https://images.unsplash.com/photo-1674905621991-8797e7a502c7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyMnx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60"),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                )
            }
//            SmallTopAppBar(
//                navigationIcon = {Icon(Icons.Filled.Settings, "Settings", tint = Color.White)},
//                title = { Text("Personal Safety", textAlign = TextAlign.Center) },
//            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            floatingActionButtonCompose()
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
            ) {
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = "Hi Buddy", fontSize = 30.sp
                )
                Spacer(modifier = Modifier.size(20.dp))
                AlertComposeSurface(
                    mainTitle = "Use Emergency SOS to get help fast",
                    subTitle = "Automatically call for help, share info with your emergency contacts, and record a video with 5 quick presses",
                    imageUrl = "https://cdn-icons-png.flaticon.com/512/2385/2385502.png"
                )
                Spacer(modifier = Modifier.size(10.dp))
                AlertComposeSurface(
                    mainTitle = "Turn on car crash detection",
                    subTitle = "Get help calling on 108 after a crash",
                    imageUrl = "https://static.vecteezy.com/system/resources/previews/007/269/595/non_2x/car-accident-illustration-on-a-background-premium-quality-symbols-icons-for-concept-and-graphic-design-vector.jpg"
                )
            }
        },
    )

}

@Composable
fun AlertComposeSurface(mainTitle: String, subTitle: String, imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(size = 30.dp))
            .background(color = Color(0xff4B4B4B)),
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = mainTitle,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.size(10.dp))
                IconButton(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = colorScheme.onSecondary,
                            shape = CircleShape
                        ),
                    onClick = { },
                ) {
                    Icon(
                        Icons.Outlined.Close,
                        "Settings",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = subTitle,
                    fontSize = 15.sp,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(
                            color = colorScheme.onSecondary,
                            shape = CircleShape
                        ),                       // clip to the circle shape
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ElevatedButton(
                    onClick = { /*TODO*/ }) {
                    Text("Get Started")
                }
                Spacer(modifier = Modifier.size(10.dp))
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text("Watch a demo")
                }
            }
        }
    }
}

@Composable
fun floatingActionButtonCompose() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 30.dp))
                .background(color = Color(0xffFCC934))
                .weight(1f)
                .height(100.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            ) {
                Icon(
                    Icons.Outlined.CheckCircle,
                    "Settings",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    "Personal Safety", fontSize = 16.sp,
                    color = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 30.dp))
                .background(color = Color(0xffEE675C))
                .weight(1f)
                .height(100.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            ) {
                Icon(
                    Icons.Outlined.Send,
                    "Settings",

                    tint = Color.Black,
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    "Emergency Sharing", fontSize = 16.sp,
                    color = Color.Black,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PersonalSafetyTheme {
        ScaffoldComposeFunc()
    }
}