package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* //1 GlobalScope.launch {
            delay(3000L)
            Log.d(TAG,"Coroutine says hello from thread ${Thread.currentThread().name}")
        }
        Log.d(TAG,"Hello from thread ${Thread.currentThread().name}") //1*/
      /* // 2 GlobalScope.launch {
            val ans1 = doNetworkCall1()
            val ans2 = doNetworkCall2()
            Log.d(TAG, ans1)
            Log.d(TAG, ans2)
        } //2*/
    /* // 3  GlobalScope.launch(Dispatchers.IO) {
     Log.d(TAG,"Starting coroutine in the thread ${Thread.currentThread().name}")
     val ans=doNetworkCall()
     withContext(Dispatchers.Main){
         Log.d(TAG,"Setting text in thread ${Thread.currentThread().name}")
         tvDummmy.text=ans
     }//3*/
      /*//4  Log.d(TAG,"Before runblocking")
        runBlocking {
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG, "Finished IO coroutine 1")
            }
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG, "Finished IO coroutine 2")
            }
            Log.d(TAG,"Start of runblocking")
            delay(5000L)
            Log.d(TAG,"End of runblocking")
        }
        Log.d(TAG,"After runblocking")//4*/
      /* //5  val job=GlobalScope.launch (Dispatchers.IO){
           /* repeat(5) {
                Log.d(TAG,"Coroutine is still working")
                delay(1000L)
            }*/
            Log.d(TAG,"Starting long running calculation ")
            withTimeout(3000L) {
                for(i in 30..40) {
                    if(isActive) {
                        Log.d(TAG,"Result for i=$i:${fib(i)}")
                    }
                }
            }
            Log.d(TAG,"Ending long running calculation")
        }
        runBlocking {
            //job.join()
            delay(2000L)
            job.cancel()
           // Log.d(TAG,"Main Thread is continuing ")
            Log.d(TAG,"Cancel job! ")
        }//5*/
 }
}

/* // 2 suspend fun doNetworkCall1(): String {
 delay(3000L)
 return "This is answer"
}
suspend fun doNetworkCall2(): String {
 delay(3000L)
 return "This is answer"
}  // 2*/
/* //3 suspend fun doNetworkCall(): String {
 delay(3000L)
 return "This is answer"
}  // 3*/
    /*//5  fun fib(n:Int) :Long {
          return if(n==0) 0
          else if(n==1) 1
          else fib(n-1) + fib(n-2)
      } //5*/
}