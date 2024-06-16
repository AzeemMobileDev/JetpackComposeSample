package com.dev.azeem.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.azeem.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppView()
        }
    }
}

@Composable
fun AppView() {
    JetpackComposeTheme {
        ClickMe(listSize = 6, modifier = Modifier)
    }
}

@Composable
fun ClickMe(listSize: Int, modifier: Modifier) {
    LazyColumn(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        for (i in 1..listSize) {
            item {
                Box {
                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                tint = colorResource(id = R.color.black),
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp)
                                    .align(Alignment.CenterVertically),
                                painter = painterResource(id = R.drawable.baseline_android_24),
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Item $i",
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 4.dp)
                                    .weight(1f),
                                color = Color.Blue
                            )
                            Button(
                                modifier = Modifier,
                                colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_500)),
                                onClick = { Log.i("Item clicked", "Position $i") }
                            ) {
                                Text(text = "Add")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Divider(color = colorResource(id = R.color.teal_200))
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    AppView()
}