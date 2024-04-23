package com.example.imadassesment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // used mapOF i could have also used listOf this is where my data is stored and is where programme will serarch for a match.
    private val map = mapOf(
        "You are 95 years old, which is the same age as Nelson Mandela. Mandela was a Anti-apartheid revolutionary in South Africa." to 95,
        "You are 30 years old, which is the same age as Steve Biko. Biko was the leader of the Black Conciousness Movement." to 30,
        "You are 39 years old, which is the same age as Martin Luther King Jr. King was a American civil rights leader. " to 39,
        "You are 78 years old, which is the same age as Mahatma Gandhi. Gandhi was a leader for the Indian Independence Movement." to 78,
        " You are 87 years old, which is the same age as Mother Teresa. Mother Teresa was a Albanian-Indian Roman Catholic nun and missionary." to 87,
        " You are 76 years old, which is the same age as Albert Eienstein. Eienstein is a famous scientist which is known for his theory of relativity." to 76,
        " You are 52 years old, which is the same age as William Shakespeare. Shakespeare is well known for his English playwrights and poetry. " to 52,
        "You are 67 years old, which is the same age as Leornardo Da Vinci. Da Vinci is known for his contribution to ART.(MONA LISA)" to 67,
        " You are 90 years old, which is the same age as Desmond Tutu. Tutu was a Nobel Peace Prize winner based on his prominent voice against Apartheid." to 90,
        "You are 84 years old, which is the same age as Isaac Newton. Newton is well known today based on his laws of motion." to 84
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // all variables needed for this code. inputAge will be string as age can only be an int.
        var inputAge = findViewById<EditText>(R.id.AGE)
        var history = findViewById<Button>(R.id.GENARATE)
        var clearButton = findViewById<Button>(R.id.CLEAR)
        var historyView = findViewById<TextView>(R.id.HISTORY)

        // setOnClickListener, this is important as it tells the program that once its clicked it should execute following code.
        history.setOnClickListener {
            // inputNumber is equal to the value that user inputs and can only be a int.
            val inputNumber = inputAge.text.toString().toIntOrNull()

            // could also use inequalities to represant(<,>) range.
            if (inputNumber != null && inputNumber in 20..100) { // Check if input is not null and within range 20 and 100
                val histories = map.entries.find { it.value == inputNumber }?.key

                val outputString = if (histories != null) {
                    "$histories"
                } else {
                    "The is no historical figure at $inputNumber years old found."

                }

                historyView.text = outputString
            }else {
                if (inputNumber == null) {
                    historyView.text = " Please enter age."
                } else
                    if (inputNumber !in 20..100)

                        historyView.text =
                            "$inputNumber year old is out of our range. Please enter a valid number between 20 and 100."

            }
            }

            // once button clicked data is cleared and goes back to start.
            clearButton.setOnClickListener {
                historyView.text = ""
                inputAge.text.clear()
            }
        }
    }



