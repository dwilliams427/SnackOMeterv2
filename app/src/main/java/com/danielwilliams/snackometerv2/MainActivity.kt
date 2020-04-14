package com.danielwilliams.snackometerv2

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity() {
    var mealCounter = 0
    var snackCounter = 0

    //setup shared preferences
//    private val pref: SharedPreferences =  getSharedPreferences("MEAL_COUNTER", Context.MODE_PRIVATE)
//    private val snackSharedPreference: SharedPreferences =  getSharedPreferences("SNACK_COUNTER", Context.MODE_PRIVATE)
//    var mealEditor = pref.edit()
//    var snackEditor = snackSharedPreference.edit()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setup shared preferences
        val pref: SharedPreferences =  this.getSharedPreferences("COUNTERS", Context.MODE_PRIVATE)

        //setup meal counter
        mealVal.setText("" + mealCounter)
        mealPlusButton.setOnClickListener{
            //setup shared preferences
            val mealEditor:SharedPreferences.Editor = pref.edit()


            mealVal.setText("" + ++mealCounter)

            // setup shared pref
            mealEditor.putString("MEAL_COUNTER", mealVal.text.toString())
            mealEditor.apply()
            mealEditor.commit()

            Toast.makeText(applicationContext,"meal PLUS button",Toast.LENGTH_SHORT).show()
        }
        mealMinusButton.setOnClickListener{
            Toast.makeText(applicationContext,"meal MINUS button",Toast.LENGTH_SHORT).show()
            if (mealCounter <= 0){
                mealVal.setText("0")
            }
            else mealVal.setText("" + --mealCounter)
        }

        //setup snack counter
        snackVal.setText("" + snackCounter)
        snackPlusButton.setOnClickListener {
            Toast.makeText(applicationContext,"snack PLUS button",Toast.LENGTH_SHORT).show()
            snackVal.setText("" + ++snackCounter)
        }
        snackMinusButton.setOnClickListener{
            Toast.makeText(applicationContext,"snack MINUS button",Toast.LENGTH_SHORT).show()
            if (snackCounter <= 0){
                snackVal.setText("0")
            }
            else snackVal.setText("" + --snackCounter)
        }


    }

//    fun onClick(v: View){
////        mealEditor.putString("MEAL_COUNTER", mealVal.text.toString())
////        mealEditor.commit()
////        snackEditor.putString("SNACK_COUNTER", snackVal.text.toString())
////        snackEditor.commit()
//    }

    override fun onPause() {
        super.onPause()

//        val preferencesEditor: Editor = mPreferences.edit()
//        preferencesEditor.putInt(COUNT_KEY, mCount)
//        preferencesEditor.putInt(COLOR_KEY, mColor)
//        preferencesEditor.apply()
    }


    override fun onDestroy() {
        super.onDestroy()


    }





}
