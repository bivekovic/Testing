package com.algebra.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.algebra.testing.utils.*

class MainActivity : AppCompatActivity() {

    private lateinit var etFirstNumber: EditText
    private lateinit var etSecondNumber: EditText
    private lateinit var bAdd: Button
    private lateinit var bSubtract: Button
    private lateinit var bMultiply: Button
    private lateinit var bDivide: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWidgets()
        setupListeners()
    }

    private fun initWidgets() {
        etFirstNumber  = findViewById(R.id.etFirstNumber)
        etSecondNumber = findViewById(R.id.etSecondNumber)
        bAdd           = findViewById(R.id.bAdd)
        bSubtract      = findViewById(R.id.bSubtract)
        bMultiply      = findViewById(R.id.bMultiply)
        bDivide        = findViewById(R.id.bDivide)
        tvResult       = findViewById(R.id.tvResult)
    }

    private fun setupListeners( ) {
        bAdd.setOnClickListener {
            val firstNumber  = transformToNumber( etFirstNumber.text.toString( ) )
            val secondNumber = transformToNumber( etSecondNumber.text.toString( ) )

            if ( validateInputs( firstNumber, secondNumber ) ) {
                val result = add( firstNumber!!, secondNumber!! )
                tvResult.text = "$firstNumber + $secondNumber = $result"
                cleanFields( )
            }
        }

        bSubtract.setOnClickListener {
            val firstNumber  = transformToNumber( etFirstNumber.text.toString( ) )
            val secondNumber = transformToNumber( etSecondNumber.text.toString( ) )

            if ( validateInputs( firstNumber, secondNumber ) ) {
                val result = subtract( firstNumber!!, secondNumber!! )
                tvResult.text = "$firstNumber - $secondNumber = $result"
                cleanFields( )
            }
        }

        bMultiply.setOnClickListener {
            val firstNumber  = transformToNumber( etFirstNumber.text.toString( ) )
            val secondNumber = transformToNumber( etSecondNumber.text.toString( ) )

            if ( validateInputs( firstNumber, secondNumber ) ) {
                val result = multiply( firstNumber!!, secondNumber!! )
                tvResult.text = "$firstNumber x $secondNumber = $result"
                cleanFields( )
            }
        }

        bDivide.setOnClickListener {
            val firstNumber  = transformToNumber( etFirstNumber.text.toString( ) )
            val secondNumber = transformToNumber( etSecondNumber.text.toString( ) )

            if ( validateInputs( firstNumber, secondNumber ) ) {
                val result = divide( firstNumber!!, secondNumber!! )
                tvResult.text = "$firstNumber x $secondNumber = $result"
                cleanFields( )
            }
        }
    }

    private fun cleanFields() {
        etFirstNumber.setText("")
        etSecondNumber.setText("")
    }

    private fun validateInputs(firstNumber: Int?, secondNumber: Int?): Boolean {
        if (firstNumber == null) {
            etFirstNumber.error = "Missing first number"
            if (secondNumber == null) {
                etSecondNumber.error = "Missing second number"
            }
            return false
        }

        if (secondNumber == null) {
            etSecondNumber.error = "Missing second number"
            return false
        }

        return true
    }
}
