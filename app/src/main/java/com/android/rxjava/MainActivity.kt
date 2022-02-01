package com.android.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {
    val TAG = this.javaClass.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val observable = Observable.just(1)
        /*
         also val observable = Observable.just(1 , 2 , 3 , 4 , 5)
         Just operator can take up to 10 values / objects .
         val observable = Observable.just(1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11) -> error

         val list =  mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12)
         val observable = Observable.just(list)  -> No error because its a single object

         */
        val observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG,"onSubscribe")
            }

            override fun onNext(t: Int?) {
                Log.d(TAG,"onNext $t")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG,"onError ${e.toString()}")
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete")
            }
        }

        observable.subscribe(observer)
    }
}