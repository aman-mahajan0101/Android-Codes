package com.example.todolist_sqlite.db

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

object TodoTable {
    val TABLE_NAME = "todos"
    object Columns {
        val ID = "id"
        val TASK = "task"
        val Done = "done"
    }

    val CMD_CREATE_TABLE = """
    CREATE TABLE IF NOT EXISTS $TABLE_NAME
    (
    ${Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
    ${Columns.TASK} TEXT,
    ${Columns.Done} BOOLEAN
    );
    """.trimIndent()

    fun insertTodo(db : SQLiteDatabase,todo: Todo){
        val row = ContentValues()
        row.put(Columns.TASK,todo.task)
        row.put(Columns.Done,todo.done)

        db.insert(TABLE_NAME,null,row)


    }
    fun getAllTodos(db : SQLiteDatabase):ArrayList<Todo> {
        val todos = ArrayList<Todo>()
        var c =  db.query(
           TABLE_NAME,
           arrayOf(Columns.ID,Columns.TASK,Columns.Done),
           null,null,
           null,null,
           null)

       while(c.moveToNext()){
           val todo = Todo(
               c.getString(1),c.getInt(2)==1)
           todos.add(todo)
       }
        return todos
    }

}