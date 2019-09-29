package com.example.concentration

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    var flipCount = 0
        set(value) {
            field = value
            tvFlips?.text = "Flips: $flipCount"
        }

    var tvFlips: TextView? = null

    var cardButtonID = arrayOf(R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4)
    var emojiChoices = arrayOf("❤", "😎", "😀", "🍎")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvFlips = findViewById(R.id.tv_flips)
    }


    fun flipCard(emoji: String, button: Button) {
        if (button.text == emoji) {
            button.text = ""
            button.setBackgroundColor(Color.argb(255, 179, 136, 255))
        } else {
            button.text = emoji
            button.setBackgroundColor(Color.WHITE)
        }
    }

    fun touchCard(view: View) {
        flipCount += 1

        val cardNumber = cardButtonID.indexOf(view.id)

        flipCard(emojiChoices[cardNumber], view as Button)
    }

//    fun touchCardTwo(view: View) {
//        flipCount += 1
//        flipCard("❤", view as Button)
//    }
}
