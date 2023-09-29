package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var inputTextView: TextView
    private lateinit var outputTextView: TextView
    private var currentInput: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTextView = findViewById<TextView>(R.id.input)
        outputTextView = findViewById<TextView>(R.id.output)

        // Set click listeners for digit buttons (0-9), operators, and clear button
        val buttonIds = arrayOf(
            R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven,
            R.id.eight, R.id.nine,
            R.id.dot, R.id.plus, R.id.minus, R.id.multiply, R.id.divide, R.id.percent, R.id.bracket
        )

        for (buttonId in buttonIds) {
            findViewById<Button>(buttonId).setOnClickListener { onButtonClick(it) }
        }

        // Set click listener for equals button
        findViewById<Button>(R.id.equal).setOnClickListener { evaluateExpression() }

        // Set click listener for clear button
        findViewById<Button>(R.id.clear).setOnClickListener { clearInput() }

    }
    private fun onButtonClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        when (buttonText) {
            "=" -> evaluateExpression()
            "C" -> clearInput()
            else -> appendToInput(buttonText)
        }
    }

    private fun clearInput() {
        currentInput = ""
        inputTextView.text = ""
        outputTextView.text = ""
    }

    private fun appendToInput(text: String) {
        currentInput += text
        inputTextView.text = currentInput
    }

    private fun evaluateExpression() {
        outputTextView.text = "evaluated"
    }


}
