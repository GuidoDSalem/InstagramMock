package com.practice.instagrammock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.rotateRad
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.instagrammock.ui.theme.InstagramMockTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            InstagramMockTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    var dato by remember {
                        mutableStateOf(0.9f)
                    }

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ){
                        Header(modifier = Modifier
                            .background(MaterialTheme.colors.background)
                            .fillMaxWidth()
                            .height(70.dp)
                            .padding(10.dp)
                        )
                        LazyColumn(modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)){
                            item {
                                Stories(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp)
                                    .padding(5.dp))
                            }
                            items(5){ it ->
                                Posts(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(400.dp),
                                    num = it)
                            }
                        }
                        BottomBar(modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun PostHeader(
    num: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        PerfilStory(num = num){}
        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = "User name",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
            )
            Text(
                text = "Ubication",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground,
            )
        }
    }

}

@Composable
fun PostBottons(modifier: Modifier = Modifier){
    Row(
        modifier = modifier.padding(20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "",
            tint = MaterialTheme.colors.onBackground
        )
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "",
            tint = MaterialTheme.colors.onBackground
        )
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "",
            tint = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "",
            tint = MaterialTheme.colors.onBackground
        )

    }
}

@Composable
fun PostInfo(modifier: Modifier = Modifier.fillMaxWidth()) {
    val likes:Int = Math.random().toInt()
    val comments:Int = (Math.random()%200).toInt()
    val hours:Int = (Math.random()%12).toInt()

    Column(modifier = modifier.padding(start = 15.dp)) {
        Text(
            text = "${likes.toString()} Likes",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
        )
        Text(
            text = "${comments.toString()} Comments",
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
        )
        Text(
            text = "${hours} hours ago",
            style = MaterialTheme.typography.subtitle2,
            color = Color.Gray,
        )

    }
}

@Composable
fun Posts(
    modifier: Modifier = Modifier.fillMaxWidth(),
    num: Int,
) {
    //Spacer(modifier = Modifier.height(500.dp))
    Column(modifier = modifier) {
        PostHeader(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            num = num)
        Spacer(modifier = Modifier.height(5.dp))

        Image(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.playas) ,
            contentDescription = "Playa",
            contentScale = ContentScale.FillBounds
        )
        PostBottons(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp))
        PostInfo()
        Spacer(modifier = Modifier.height(30.dp))
        Divider()
        Spacer(modifier = Modifier.height(10.dp))


    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = stringResource(id = R.string.app_name),
                tint = MaterialTheme.colors.onBackground
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = stringResource(id = R.string.app_name),
                tint = MaterialTheme.colors.onBackground
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = stringResource(id = R.string.app_name),
                tint = MaterialTheme.colors.onBackground
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = stringResource(id = R.string.app_name),
                tint = MaterialTheme.colors.onBackground
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = stringResource(id = R.string.app_name),
                tint = MaterialTheme.colors.onBackground
            )
        }
    }

}

@Composable
fun Stories(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly

    ){
        items(15){ it ->
            Spacer(modifier = Modifier.width(15.dp))
            PerfilStory(Modifier
                .fillMaxHeight()
                .aspectRatio(1f),it){}

        }
    }

}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier.weight(0.6f),
            text = "Instagram",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onBackground,
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "",//stringResource(id = R.string.),
                tint = MaterialTheme.colors.onBackground
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "",//stringResource(id = R.string.),
                tint = MaterialTheme.colors.onBackground
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "",//stringResource(id = R.string.),
                tint = MaterialTheme.colors.onBackground
            )
        }

    }
    Divider()
}


@Composable
fun PerfilStory(
    modifier: Modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f),
    num: Int,
    hasBennOpened: Boolean = false,
    onClick: ()->Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .clickable { onClick }
            ,
        ){

            rotate(-45f){
                drawCircle(
                    brush = Brush.horizontalGradient(
                        listOf(Color.Yellow,Color.Red,Color.Magenta)
                    ),
                    radius = size.height/2,
                    style = Stroke(width = 3.dp.toPx()),
                )
            }

            drawCircle(
                color = Color.Gray,
                radius = ((size.height/2) * 0.9).toFloat()
            )

        }
        Text(
            text = num.toString(),
            style = MaterialTheme.typography.h4,
            color = Color.Black,
        )

    }


}

@Composable
fun MyArc(
    modifier: Modifier = Modifier,
    dato: Float)
{
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)

//            .size(300.dp, 300.dp)
        ){
            drawArc(
                color = Color.Green,
                startAngle = -90f,
                sweepAngle = dato * 360,
                useCenter = false,
                style = Stroke(
                    6.dp.toPx(),
//                        miter = 0.5f,
                    cap = StrokeCap.Round
                ),
            )
        }
        Text(
            text = (dato*100).toInt().toString(),
            style = MaterialTheme.typography.h3,
            color = Color.Black,
        )
    }


}

