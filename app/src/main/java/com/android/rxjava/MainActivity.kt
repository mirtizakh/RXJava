package com.android.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG = this.javaClass.name
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // justOperator()
        // fromOperator()
        // fromIterableOperator()

        /* rangeOperator().subscribe(
            {
                Log.d(TAG, "onNext $it")
            },
            {
                Log.d(TAG, "onError ${it.toString()}")
            },
            {
                Log.d(TAG, "onComplete")
            }
        ) */

         /* repeatOperator().subscribe(
            {
                Log.d(TAG, "onNext $it")
            },
            {
                Log.d(TAG, "onError ${it.toString()}")
            },
            {
                Log.d(TAG, "onComplete")
            }
        ) */

        /* intervalOperator().subscribe(
            {
                Log.d(TAG, "onNext $it")
            },
            {
                Log.d(TAG, "onError ${it.toString()}")
            },
            {
                Log.d(TAG, "onComplete")
            }
        ) */
    }
}