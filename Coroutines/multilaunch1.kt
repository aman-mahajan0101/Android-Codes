import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch

fun main(){
    runBlocking{
    launch {printList("1")}
    launch {printList("2")}
    launch {printList("3")}
    launch {printList("4")}
    launch {printList("5")}
    launch {printList("6")}
    launch {printList("7")}
    launch {printList("8")}
    launch {printList("9")}
    launch {printList("10")}
    launch {printList("11")}
    launch {printList("12")}
}
}

suspend fun printList(id:String){
    for(i in 0 until 10000){
        if(i==1000){
            withContext(Dispatchers.IO){println("looper $id iteration $i thread ${java.lang.Thread.currentThread().name}")}
      }
    }
}