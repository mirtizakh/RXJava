package com.android.rxjava

import android.util.Log
import com.android.rxjava.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

val numList =  mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12)
val numArray1 =  arrayOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12)
val numArray2 =  arrayOf(1,2,3,4,5,6,7,8,9,10,11,12)

fun justOperator() {
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
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: Int?) {
            Log.d(TAG, "onNext $t")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError ${e.toString()}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }
    }

    observable.subscribe(observer)

}

fun fromOperator(){
    // From operator convert various other objects and data types into Observables
    // Unlike just, From() creates an Observable from set of items using an Iterable, which means each item is emitted one at a time.

    val observable = Observable.fromArray(numArray1)

    val observer = object : Observer<Array<Int>> {
        override fun onSubscribe(d: Disposable?) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: Array<Int>?) {
            Log.d(TAG, "onNext $t")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError ${e.toString()}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }

    observable.subscribe(observer)
}

fun fromIterableOperator(){
    val observable = Observable.fromIterable(numList)

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable?) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: Int?) {
            Log.d(TAG, "onNext $t")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError ${e.toString()}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }

    observable.subscribe(observer)
}

fun rangeOperator() : Observable<Int>{
   return Observable.range(1,10)
}