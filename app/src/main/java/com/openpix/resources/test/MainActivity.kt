package com.openpix.resources.test

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.openpix.resources.ext.dp
import com.openpix.resources.ext.pressDrawableSelector
import com.openpix.resources.ext.shape
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.background = shape {
            shape = GradientDrawable.RECTANGLE // 矩形
            cornerRadius = 10.dp.toFloat() // 圆角
            colors = intArrayOf(Color.parseColor("#ff00ff"), Color.parseColor("#800000ff")) //渐变色
            gradientType = GradientDrawable.LINEAR_GRADIENT // 渐变类型
            orientation = GradientDrawable.Orientation.LEFT_RIGHT // 渐变方向
            setStroke(2.dp, Color.parseColor("#ffff00")) // 描边宽度和颜色
        }

        button2.background = pressDrawableSelector {
            pressedDrawable = shape {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 10.dp.toFloat()
                setColor(Color.BLUE)
                setStroke(2.dp,Color.parseColor("#ffff00"))
            }
            unpressedDrawable = shape {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 10.dp.toFloat()
                setColor(Color.GRAY)
                setStroke(2.dp,Color.parseColor("#ffff00"))
            }
        }

        button3.background = pressDrawableSelector {
            pressedDrawable = AppCompatResources.getDrawable(this@MainActivity, R.drawable.bg_next_pressed)
            unpressedDrawable = AppCompatResources.getDrawable(this@MainActivity,R.drawable.bg_next_normal)
        }
    }
}