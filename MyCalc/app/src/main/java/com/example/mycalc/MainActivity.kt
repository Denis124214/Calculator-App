package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.mycalc.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)

        var button_clean = binding.buttonClear
        var button_back = binding.buttonBack
        var button_bracket_left = binding.buttonBracketLeft
        var button_bracket_right = binding.buttonBracketRight
        var button_7 = binding.button7
        var button_8 = binding.button8
        var button_9 = binding.button9
        var button_multiply = binding.buttonMultiply
        var button_4 = binding.button4
        var button_5 = binding.button5
        var button_6 = binding.button6
        var button_divide = binding.buttonDivide
        var button_1 = binding.button1
        var button_2 = binding.button2
        var button_3 = binding.button3
        var button_plus = binding.buttonPlus
        var button_0 = binding.button0
        var button_dot = binding.buttonDot
        var button_minus = binding.buttonMinus
        var button_equal = binding.buttonEqual

        button_clean.setOnClickListener {
            binding.input.text = ""
            binding.output.text = ""
        }

        button_back.setOnClickListener {
            removeLastSymbol()
        }

        button_bracket_left.setOnClickListener {
            binding.input.text = addToInput("(")
        }

        button_bracket_right.setOnClickListener {
            binding.input.text = addToInput(")")
        }

        button_7.setOnClickListener {
            binding.input.text = addToInput("7")
        }

        button_8.setOnClickListener {
            binding.input.text = addToInput("8")
        }

        button_9.setOnClickListener {
            binding.input.text = addToInput("9")
        }

        button_multiply.setOnClickListener {
            binding.input.text = addToInput("*")
        }

        button_4.setOnClickListener {
            binding.input.text = addToInput("4")
        }

        button_5.setOnClickListener {
            binding.input.text = addToInput("5")
        }

        button_6.setOnClickListener {
            binding.input.text = addToInput("6")
        }

        button_divide.setOnClickListener {
            binding.input.text = addToInput("/")
        }

        button_1.setOnClickListener {
            binding.input.text = addToInput("1")
        }

        button_2.setOnClickListener {
            binding.input.text = addToInput("2")
        }

        button_3.setOnClickListener {
            binding.input.text = addToInput("3")
        }

        button_plus.setOnClickListener {
            binding.input.text = addToInput("+")
        }

        button_0.setOnClickListener {
            binding.input.text = addToInput("0")
        }

        button_dot.setOnClickListener {
            binding.input.text = addToInput(".")
        }

        button_equal.setOnClickListener {
            showResult()
        }

        button_minus.setOnClickListener {
            binding.input.text = addToInput("-")
        }
    }

    fun addToInput(bindingValue: String): String { // подсмотрел. ошибка 1. после onCreate функций идут
        return "${binding.input.text}$bindingValue"
    }

    fun removeLastSymbol () {
        var currentText = binding.input.text
        if (currentText.isNotEmpty()) { // не знаю. Догадался бы ли я условия использовать, случайно подсмотрел
            var udpateText = currentText.substring(0, currentText.length - 1)
            binding.input.text = udpateText
        }
        else {
            binding.input.text = ""
        }
    }

    fun showResult() {
        try {
            var expression = binding.input.text.toString()
            var result = Expression(expression).calculate()
            if (result.isNaN()) {
                binding.output.text = "Error"
            }
            else {
                binding.output.text = DecimalFormat("0.######").format(result).toString()
            }
        }
        catch (e: Exception) {
            binding.output.text = "Error"
        }

    }
    }







