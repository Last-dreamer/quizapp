package com.dreamer.quizapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.lang.Math.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

     val PROGRESS_BAR_INCREMANTATION:Int = 8

     var truebtn:Button?=null
     var falsebtn:Button?=null
     var  questText:TextView?=null

    var progress:ProgressBar?=null
    var scoreText:TextView?= null

    var  index:Int?=0
      var mQuestNum:Int?=null
    var score:Int?=1



   var questbank = arrayOf(
       TrueFalse(R.string.question_1,true),
       TrueFalse(R.string.question_2,true),
       TrueFalse(R.string.question_3,true),
       TrueFalse(R.string.question_4,true),
       TrueFalse(R.string.question_5,true),
       TrueFalse(R.string.question_6,false),
       TrueFalse(R.string.question_7,true),
       TrueFalse(R.string.question_8,false),
       TrueFalse(R.string.question_9,true),
       TrueFalse(R.string.question_10,false),
       TrueFalse(R.string.question_11,false),
       TrueFalse(R.string.question_12,true),
       TrueFalse(R.string.question_13,true)
   )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        truebtn = findViewById(R.id.button)
        falsebtn = findViewById(R.id.button2)
        questText = findViewById(R.id.question)

        progress = findViewById(R.id.progressBar)
        scoreText = findViewById(R.id.score_id)



        mQuestNum =  questbank[index!!].questId

         questText!!.setText(mQuestNum!!)


        truebtn!!.setOnClickListener( View.OnClickListener { view ->
            questUpdate()
            checkAnswar(true)

        })


        falsebtn!!.setOnClickListener(View.OnClickListener {
            view ->
            questUpdate()
            checkAnswar(false)

        })


    }




      fun questUpdate(){
         index =(index!!+ 1) % 13
          mQuestNum =  questbank[index!!].questId
          questText!!.setText(mQuestNum!!);
          progress!!.incrementProgressBy(PROGRESS_BAR_INCREMANTATION)
          scoreText!!.setText("score"+ score +"/ 13")


          if(index==0){
              var alert = AlertDialog.Builder(this);
              alert.setTitle("Game OVer")
              alert.setCancelable(false)
              alert.setMessage("Your score is $score  points")
              alert.setPositiveButton("Close Application",{dialog,which->
                   finish()
              })

              alert.show()

          }
      }


    fun checkAnswar(userSelection:Boolean){


        var correctAns:Boolean? = questbank[index!!].truefalse

        if(userSelection ==  correctAns){

            Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
           score= score!!+ 1
        }else{
            Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show()
        }
    }

    // templete class for random answar.... or module
    inner class TrueFalse {
        var questId: Int?=null
        var truefalse: Boolean? = null
        constructor(questIdres: Int, truefalseres: Boolean) {
          questId = questIdres
          truefalse = truefalseres
        }
    }
}
