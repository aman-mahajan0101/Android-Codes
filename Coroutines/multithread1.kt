fun main(){
    java.lang.Thread {printList("1")}.start()
    java.lang.Thread {printList("2")}.start()
    java.lang.Thread {printList("3")}.start()
    java.lang.Thread {printList("4")}.start()
    java.lang.Thread {printList("5")}.start()
    java.lang.Thread {printList("6")}.start()
    java.lang.Thread {printList("7")}.start()
    java.lang.Thread {printList("8")}.start()
    java.lang.Thread {printList("9")}.start()
    java.lang.Thread {printList("10")}.start()
    java.lang.Thread {printList("11")}.start()
    java.lang.Thread {printList("12")}.start()
}

fun printList(id:String){
    for(i in 0 until 10000){
        if(i==1000){
            println("looper $id iteration $i thread ${java.lang.Thread.currentThread().name}")
        }
    }
}