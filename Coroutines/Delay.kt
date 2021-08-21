import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.launch
import java.lang.Thread

fun main(){println("Start = ${java.lang.System.currentTimeMillis()}")
    runBlocking{
         launch{task1()}
         launch{task2()}
    }
   println("End = ${java.lang.System.currentTimeMillis()}")
}

private suspend fun task1(){
    println("Starting task 1 on ${Thread.currentThread()}.name")
    delay(1000)
    println("Ending task 1 on ${Thread.currentThread()}.name")
}
private suspend fun task2(){
    println("Starting task 2 on ${Thread.currentThread()}.name")
    delay(1000)
    println("Ending task 2 on ${Thread.currentThread()}.name")
}