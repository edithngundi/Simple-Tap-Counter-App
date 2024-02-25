package com.msedith.tapcounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    private var count = 0
    private var tapMultiplier = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countTextView: TextView = findViewById(R.id.countTextView)
        val tapButton: Button = findViewById(R.id.tapButton)
        val upgradeButton: Button = findViewById(R.id.upgradeButton)

        tapButton.setOnClickListener {
            count += tapMultiplier
            countTextView.text = count.toString()
            Toast.makeText(this, "Count increased", Toast.LENGTH_SHORT).show()
        }

        upgradeButton.setOnClickListener {
            if (count >= 100) {
                count -= 100
                tapMultiplier = 2
                countTextView.text = count.toString()
                Toast.makeText(this, "Upgrade successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You need 100 taps to upgrade!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
