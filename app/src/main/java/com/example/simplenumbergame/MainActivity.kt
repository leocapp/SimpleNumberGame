package com.example.simplenumbergame

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {
    var points = 0//act as the score, not static so use var so we can change it
    var randomNumberBound = 100 //global variable for the random numbers
    override fun onCreate(savedInstanceState: Bundle?) {//main in java = onCreate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // start of application, as it opens, like main in java
        initialize()//this will make the random numbers show up as soon as you open it
    }
    fun lessThanButton(view: View){
        checkRelationship("lessThan")
    }
    fun equalButton(view:View){
        checkRelationship("equal")
    }
    fun greaterThanButton(view: View){
        checkRelationship("greaterThan")
    }
    private fun checkRelationship(buttonClicked: String){
        //val firstNumber = findViewById<TextView>(R.id.first_number)//finds button by id TextView then uses the first_number text field
        val num1 = first_number.text.toString().toInt()//this is done because its text that needs to be converted, not sure why
        val num2 = second_number.text.toString().toInt()
        var message = ""

        //check numbers
        if(num1 < num2 && buttonClicked == "lessThan") {
            //increase score
            points++
            message = "Correct!"
        }else if(num1 == num2 && buttonClicked == "equal"){
            points++
            message = "Correct!"
        }else if(num1 > num2 && buttonClicked == "greaterThan"){
            points++
            message = "Correct!"
        }else{
            //decrease score
            points--
            message = "Wrong!!"
        }
        //Toast.makeText(this,"$message",Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"$message",Toast.LENGTH_SHORT).show()//LOOK AT THIS AGAIN AFTER CLASS IN THE SOURCE CODE AND FIX MESSAGES
        score.text = "Score: $points"//makes the score change based on if statement
        initialize()//this will make new numbers show up after clicking less than
    }
   // text = "Correct!" Toast.LENGTH_SHORT).show()

    fun initialize(){

        first_number.text = "${generateRandomNumber(randomNumberBound)}" //this changes the text of the textfield to random number
        //the dollar sign is just a toString() method
        second_number.text = "${generateRandomNumber(randomNumberBound)}"
    }
    private fun generateRandomNumber(bound: Int) = Random().nextInt(bound)

}