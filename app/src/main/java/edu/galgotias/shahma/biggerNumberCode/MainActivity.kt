package edu.galgotias.shahma.biggerNumberCode

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumberToButtons()
        btnLeft.setOnClickListener() {
            //code here will run everytime left button is clicked
            checkAnswer(true)
            assignNumberToButtons()

        }
        btnRight.setOnClickListener() {
            checkAnswer(false)
            assignNumberToButtons()
        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) leftNum > rightNum else leftNum < rightNum
        if (isAnswerCorrect) {
            //correct ans
            //change background color
            backgroundView.setBackgroundColor(Color.CYAN)
            //Show toast
            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show()
        }else {
            backgroundView.setBackgroundColor(Color.RED)
            //show toast
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }


    }

    private fun assignNumberToButtons() {
        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()

    }
}