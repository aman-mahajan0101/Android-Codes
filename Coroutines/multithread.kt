val numList = CopyOnWriteArrayList<Int>()
//val numList = ArrayList<Int>()

// fun main(){
//    for(i in 0 until 10000){
//        numList.add(i)
//     }
//     java.lang.Thread {printList("1") }.start()
//     java.lang.Thread {printList("2") }.start()
//    java.lang.Thread {printList("3") }.start()
// }

fun main(){
    for(i in 0 until 10000){
        numList.add(i)
    }
    val itr = numList.iterator()
    java.lang.Thread {dropMultiples(3,itr) }.start()
    java.lang.Thread {dropMultiples(5,itr) }.start()
    java.lang.Thread {dropMultiples(7,itr) }.start()

    for(i in numList){
        println(i)
    }
}

fun dropMultiples(n:Int, itr : MutableIterable<Int>){
    while(itr.has .hasNext()){
        val i = itr.next()
        if(i % n == 0){
            itr.remove()
        }
    }
}

// fun dropMultiples(n :Int){
//     for(i in numList){    //Also can be called as : for(i in 0 until numList.size)
//         if(i % n ==0){
//             numList.remove(i)
//         }
//     }
// }

/*

fun printList(id:String){
    for(i in 0 until 10000){
        if(id=="2" && i==500){
            java.lang.Thread.sleep(100)
        }

        if(i%100==0){
            println("$id $i")
        }
    }

    for (i in 0 until 10000){
        println(" $Thread.currentThread().id} $i")
    }*/
//}