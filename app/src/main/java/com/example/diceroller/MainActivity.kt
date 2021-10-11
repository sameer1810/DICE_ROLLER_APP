package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() /*MAKE COMPATIBLE FOR LATEST VERSION OF ANDROID*/ {

   /*initilize Image View at above setContentView will create problem
   * therefore, we hve two methods to get rid of this
   * 1) set it as null
   * 1) var diceImage: ImageView ? = null

   * 2)use lateinit keyword which promises that we will initialize it befor calling */
   lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) /*THIS SHOWS THE LAYOUT OF APP LIKE BUTTON VIW ,IMAGE VIEW ETC*/
        val rollButton: Button = findViewById(R.id.roll_button) /* button-->android widget */
        /*rollButton.text = "LETs ROLL"*/
        /*button function ....here we dynamically change the txt of button*/
        rollButton.setOnClickListener {
            /*Toast.makeText(this,"Button clicked",Toast.LENGTH_SHORT).show()*/
            /*toast is a short message aappear on screen when button is clicked
            * toast needs(class -->context(activity already have subclass context hence we use "this"),text to be displayed , duration)*/
            rollDice() /*user defined function*/
        }

        diceImage = findViewById(R.id.dice_image)
        }

    private fun rollDice() {
       /*2) val resultText: TextView = findViewById(R.id.result_text)*/
        /*1)resultText.text = "dice rolled"*/
        /*above line changes of text in view when button is clicked*/

        val randomInt = (1..6).random() /*kotlin code for finding random no*/
       /* 2)resultText.text = "$randomInt"*/

        val drawableResource = when (randomInt){
                1-> R.drawable.dice_1
                2-> R.drawable.dice_2
                3-> R.drawable.dice_3
                4-> R.drawable.dice_4
                5-> R.drawable.dice_5
                else-> R.drawable.dice_6
        }
        /*val diceImage: ImageView = findViewById(R.id.dice_image)/*every time rollDice mthod will be call
        and we have to minimize the no of call as it lages the app and expensive
        therefore, we initializes ImageView at the top*/*/

        diceImage.setImageResource(drawableResource)

    }
}
