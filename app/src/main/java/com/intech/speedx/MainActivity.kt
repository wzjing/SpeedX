package com.intech.speedx

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.compose.Composable
import androidx.core.content.ContextCompat
import androidx.ui.core.*
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBackground
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }


        setContent {
            Stack(modifier = Modifier.fillMaxSize().drawBackground(Color.White)) {
                Stack(modifier = Modifier.gravity(Alignment.Center)) {
                    Server(
                        title = "Hello",
                        description = "Vultr-JP"
                    )
                }
            }
        }
    }

    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

}

@Composable
fun Server(title: String, description: String = "") {

    Stack(modifier = Modifier.size(240.dp, 180.dp)) {
        Stack(modifier = Modifier.fillMaxSize().drawBackground(Color.White).drawShadow(elevation = 12.dp, clip = false, opacity = 0.7f)){}
        Column(
            modifier = Modifier
                .fillMaxSize()
                .drawBackground(Color.White)
                .padding(12.dp)
        ) {
            Text(text = title, fontSize = TextUnit.Sp(16))
            Text(text = description, fontSize = TextUnit.Sp(12))
        }
    }
}

@Preview(widthDp = 240, heightDp = 180, backgroundColor = 0xffffff, showBackground = true)
@Composable
fun TabPreview() {
    Stack(modifier = Modifier.fillMaxSize()) {
        Server("V2ray", "Vultr-JP")
    }
}