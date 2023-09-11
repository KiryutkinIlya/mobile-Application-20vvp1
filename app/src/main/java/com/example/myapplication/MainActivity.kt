package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import android.util.DisplayMetrics





class MainActivity : AppCompatActivity() {
    var counter = 0
    var textButton =""
    private lateinit var textCounter: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var buttonRestart: Button
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById<Button>(R.id.buttonMain)
        button2 = findViewById<Button>(R.id.button2)
        val heightButton2 = button1.getY()+1090
        val widthButton2 = button1.getX()+325

        textCounter = findViewById<TextView>(R.id.textCountTap)
        buttonRestart = findViewById<Button>(R.id.buttonRestart)
        button1.setOnClickListener {
            counter++;
            textCounter.text = counter.toString()
        }
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        button1.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    textButton=button1.text.toString()
                    counter++;
                    textCounter.text = counter.toString()
                    button1.text="Нажато"
                    button2.setX(widthButton2)
                    button2.setY(heightButton2)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    button1.text=textButton
                    true
                }
                else -> false
            }
        }
        button2.setOnClickListener {
            counter++;
            textCounter.text = counter.toString()
            button2.setX((0..(width-button2.width)).random().toFloat());
            button2.setY((0..(height-button2.height)).random().toFloat());
        }
        buttonRestart.setOnClickListener {
            counter = 0
            textCounter.text = counter.toString()
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }
}