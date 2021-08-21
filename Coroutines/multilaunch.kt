import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.runBlocking
​
val numlist = ArrayList<Int>()
​
fun main(){
    for(i in 0 until 10000){
       numlist.add(i) 
    }



       GlobalScope.launch{
        launch{printlist("1")}
        launch{printlist("2")}
        launch{printlist("3")}
        }
//     runBlocking(){
//         launch{printlist("1")}
//         launch{printlist("2")}
//         launch{printlist("3")}
//         }
    }
​
suspend fun printlist(id : String){
    for(i in 0 until 10000){
        if(i % 100 ==0){
            withContext(Dispatchers.IO){
                println("$id $i")
            }
        }
    }
}