package com.intech.speedx

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
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
            setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        }

        setContentView(TextView(this).apply {
            text = "TextView"
            gravity = Gravity.CENTER
            this.setBackgroundColor(getColor(R.color.purple_200))
            fitsSystemWindows = false
        })

//        setContent {
//
//            Stack(modifier = Modifier.fillMaxSize().drawBackground(Color.White)) {
//                Server(title = "Hello", modifier = Modifier.gravity(Alignment.Center))
//            }
//        }
    }

    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

}

@Composable
fun Server(title: String, description: String = "", modifier: Modifier = Modifier) {
    Stack(
        modifier = modifier.apply {
            sizeIn(minWidth = 120.dp, minHeight = 80.dp)
            drawBackground(Color.White)
            drawShadow(6.dp)
            clipToBounds()
        }
    ) {
        Column(modifier = Modifier.gravity(Alignment.Center)) {
            Text(text = title, fontSize = TextUnit.Sp(16))
            Text(text = description, fontSize = TextUnit.Sp(12))
        }
    }
}

@Preview(widthDp = 360, heightDp = 240, backgroundColor = 0xffffff, showBackground = true)
@Composable
fun TabPreview() {
    Stack(modifier = Modifier.fillMaxSize()) {
        Server("JP", "Vultr", modifier = Modifier.gravity(Alignment.Center))
    }
}