package com.dreamer.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {



     var truebtn:Button?=null
    var falsebtn:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        truebtn = findViewById(R.id.button)
        falsebtn = findViewById(R.id.button2)



        truebtn!!.setOnClickListener( View.OnClickListener { view ->
            Toast.makeText(this, "true", Toast.LENGTH_LONG).show()
        })


        falsebtn!!.setOnClickListener(View.OnClickListener {
            view ->
            Toast.makeText(this, "false", Toast.LENGTH_LONG).show()

        })
    }
}
