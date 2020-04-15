package com.danielwilliams.snackometerv2

/*
For implenting the shared preferences, checkout this video: https://www.youtube.com/watch?v=fJEFZ6EOM9o
It is for java but use the boiler plate code here
 */


import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity() {
    var mealCounter = 0
    var snackCounter = 0
    val CUSTOM_PREF_NAME = "Meal Counter"
    val MEAL_TEXT = "meal counter"
    val SNACK_TEXT = "snack counter"
    var mealText : String = ""
    var snackText : String = ""




    //setup shared preferences
//    private val prefs: SharedPreferences =  getSharedPreferences(CUSTOM_PREF_NAME, Context.MODE_PRIVATE)
//    var editor = prefs.edit()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //setup meal counter
        mealVal.setText("" + mealCounter)
        mealPlusButton.setOnClickListener{
            mealVal.setText("" + ++mealCounter)

            saveData()
            // setup shared pref
//            editor.putString("MEAL_TEXT", mealVal.text.toString())
//            editor.commit()
//            println("saved meal plus counter")

        }
        mealMinusButton.setOnClickListener{
            if (mealCounter <= 0){
                mealVal.setText("0")
            }
            else mealVal.setText("" + --mealCounter)
            saveData()
        }

        //setup snack counter
        snackVal.setText("" + snackCounter)
        snackPlusButton.setOnClickListener {
            snackVal.setText("" + ++snackCounter)
            saveData()
        }
        snackMinusButton.setOnClickListener{
            if (snackCounter <= 0){
                snackVal.setText("0")
            }
            else snackVal.setText("" + --snackCounter)
            saveData()
        }

        loadData()
        updateViews()
    }


    fun saveData(){
        val prefs: SharedPreferences =  getSharedPreferences(CUSTOM_PREF_NAME, Context.MODE_PRIVATE)
        var editor = prefs.edit()

        editor.putString(MEAL_TEXT, mealVal.text.toString())
        editor.putString(SNACK_TEXT, snackVal.text.toString())
        editor.apply()

        Toast.makeText(applicationContext,"data saved",Toast.LENGTH_SHORT).show()
    }

    fun loadData(){
        val prefs: SharedPreferences =  getSharedPreferences(CUSTOM_PREF_NAME, Context.MODE_PRIVATE)
        mealText = prefs.getString(MEAL_TEXT, "").toString()
        snackText = prefs.getString(SNACK_TEXT, "").toString()
    }

    fun updateViews(){
        mealVal.setText(mealText)
        snackVal.setText(snackText)
    }

    override fun onResume() {
        super.onResume()
        loadData()
        Toast.makeText(applicationContext,"Resumed",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        loadData()
        Toast.makeText(applicationContext,"Restarted",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        saveData()
        Toast.makeText(applicationContext,"Paused",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData()
        Toast.makeText(applicationContext,"fuckin DESTROYED",Toast.LENGTH_SHORT).show()
    }

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


