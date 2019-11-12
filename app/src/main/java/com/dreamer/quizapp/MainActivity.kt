package com.dreamer.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



     var truebtn:Button?=null
     var falsebtn:Button?=null
     var  questText:TextView?=null

    var  index:Int?=1

     var mQuest:Int?=null



   var questbank = arrayOf(
       TrueFalse(R.string.question_1,true),
       TrueFalse(R.string.question_2,true),
       TrueFalse(R.string.question_3,true),
       TrueFalse(R.string.question_4,true),
       TrueFalse(R.string.question_5,true),
       TrueFalse(R.string.question_6,true),
       TrueFalse(R.string.question_7,true),
       TrueFalse(R.string.question_8,true),
       TrueFalse(R.string.question_9,true),
       TrueFalse(R.string.question_10,true),
       TrueFalse(R.string.question_11,true),
       TrueFalse(R.string.question_12,true),
       TrueFalse(R.string.question_13,true)
   )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        truebtn = findViewById(R.id.button)
        falsebtn = findViewById(R.id.button2)
        questText = findViewById(R.id.question)



        mQuest =  questbank[index!!].questId

         questText!!.setText(mQuest!!)


        truebtn!!.setOnClickListener( View.OnClickListener { view ->
            Toast.makeText(this, "true", Toast.LENGTH_LONG).show()
           questUpdate()
        })


        falsebtn!!.setOnClickListener(View.OnClickListener {
            view ->
            Toast.makeText(this, "false", Toast.LENGTH_LONG).show()
            questUpdate()
        })


    }




      fun questUpdate(){
         index =(index!!+ 1) % 13
          mQuest =  questbank[index!!].questId
          questText!!.setText(mQuest!!);
     }


    // templete class for random answar....
    inner class TrueFalse {
        var questId: Int?=null
        var truefalse: Boolean? = null
        constructor(questIdres: Int, truefalseres: Boolean) {
          questId = questIdres
          truefalse = truefalseres
        }
    }
}
