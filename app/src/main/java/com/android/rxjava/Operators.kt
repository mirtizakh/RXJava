package com.android.rxjava

import android.util.Log
import com.android.rxjava.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

val numList = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
val numArray1 = arrayOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
val numArray2 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

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

fun fromOperator() {
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

fun fromIterableOperator() {
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

fun rangeOperator(): Observable<Int> {
    return Observable.range(1, 10)
}

fun repeatOperator(): Observable<Int> {
    return Observable.range(1, 10).repeat(2)
}

fun intervalOperator(): Observable<Long> {
    return Observable.interval(1, TimeUnit.SECONDS).takeWhile { value -> value <= 10 }

    /* with initial delay , that appear only one time in start
       return Observable.interval(5,1, TimeUnit.SECONDS).takeWhile { value -> value <= 10 }
     */
}

// Timer operator will call only 1 time after the delay
fun timerOperator(): Observable<Long> {
    return Observable.timer(5, TimeUnit.SECONDS)
}

fun createOperator(): Observable<Int> {
    return Observable.create {

        try {
            for (i in numList) {
                it.onNext(i * 5)
            }
            // If we don't call onComplete() here , onComplete() will not call from observer side
            it.onComplete()
        } catch (e: Exception) {
            it.onError(e)
        }

    }
}

