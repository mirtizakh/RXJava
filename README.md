# Introduction

A lot of people don't know there's a difference between RxJava and RxAndroid.
It's not much a of a difference, but it's recommended to get the most recent RxJava dependency, along with the most recent RxAndroid dependency.

Here are the main things you need to know about the difference between RxJava and RxAndroid:
1- RxAndroid contains reactive components that make using RxJava in Android easier and hassle free.
More specifically it provides a Scheduler that can schedule tasks on the main thread or any other looper - aka any thread. (It makes threading on Android very simple).

2- You could use just the RxAndroid dependency, but the releases of RxAndroid updates are less frequent. To make sure you're up-to-date with the newest RxJava components, use the newest RxJava dependency.

3- https://www.youtube.com/watch?v=AppSgPnM7-U

# Reactive Extension

The official doc describes Reactive Extension (ReactiveX) as a library for composing asynchronous
and event base program by using observable sequences.

# 3 O of RxJava

1- Observable - It does some work and emits some value.
2- Operator - It translates / modifies data from one form to another form.
3- Observer - Get those values.

# Github

https://reactivex.io/   -> Community ->   Github

# Operator
1- Just Operator
2- From Operator
3- From Iterator Operator
4- Range Operator
5- Repeat Operator
6- Interval Operator
7- Timer Operator
8- Create Operator

