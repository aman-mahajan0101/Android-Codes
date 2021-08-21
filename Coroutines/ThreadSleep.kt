import java.lang.Thread

fun main(){
    println("Start = ${java.lang.System.currentTimeMillis()}")
    java.lang.Thread{task1({println("End = ${java.lang.System.currentTimeMillis()}")})}
    java.lang.Thread{task2({println("End = ${java.lang.System.currentTimeMillis()}")})}
    println("End = ${java.lang.System.currentTimeMillis()}")
}

private fun task1(onEnd: () -> Unit){
    println("Starting task 1 on ${Thread.currentThread()}.name")
    java.lang.Thread.sleep(1000)
    println("Ending task 1 on ${Thread.currentThread()}.name")
    onEnd()
}
private fun task2(onEnd: () -> Unit){
    println("Starting task 2 on ${Thread.currentThread()}.name")
    java.lang.Thread.sleep(1000)
    println("Ending task 2 on ${Thread.currentThread()}.name")
    onEnd
}