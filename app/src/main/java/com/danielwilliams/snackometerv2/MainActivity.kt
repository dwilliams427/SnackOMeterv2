package com.danielwilliams.snackometerv2

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity() {
    var mealCounter = 0
    var snackCounter = 0
    val CUSTOM_PREF_NAME = "Meal Counter"

    //setup shared preferences
//    private val prefs: SharedPreferences =  getSharedPreferences("MEAL_PREFS", Context.MODE_PRIVATE)
//    var editor = prefs.edit()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //setup meal counter
        mealVal.setText("" + mealCounter)
        mealPlusButton.setOnClickListener{
            mealVal.setText("" + ++mealCounter)

            // setup shared pref
//            editor.putString("MEAL_COUNTER", mealVal.text.toString())
//            editor.commit()
            println("saved meal plus counter")

        }
        mealMinusButton.setOnClickListener{
            if (mealCounter <= 0){
                mealVal.setText("0")
            }
            else mealVal.setText("" + --mealCounter)



        }

        //setup snack counter
        snackVal.setText("" + snackCounter)
        snackPlusButton.setOnClickListener {
            snackVal.setText("" + ++snackCounter)
        }
        snackMinusButton.setOnClickListener{
            if (snackCounter <= 0){
                snackVal.setText("0")
            }
            else snackVal.setText("" + --snackCounter)
        }


    }

//    fun onClick(v: View?){
//        val prefs = customPreference(this, CUSTOM_PREF_NAME)
//    }

//    override fun onPause() {
//        super.onPause()
//
////        val preferencesEditor: Editor = mPreferences.edit()
////        preferencesEditor.putInt(COUNT_KEY, mCount)
////        preferencesEditor.putInt(COLOR_KEY, mColor)
////        preferencesEditor.apply()
//    }
//
//
//    override fun onDestroy() {
//        super.onDestroy()
//
//
//    }

}


