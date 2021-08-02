package com.example.todolist_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.todolist_sqlite.db.MyDbHelper
import com.example.todolist_sqlite.db.Todo
import com.example.todolist_sqlite.db.TodoTable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val todos = ArrayList<Todo>()
        var lvtodos : ListView
        lateinit var btnAddTodo : Button
        lateinit var etNewTodo : EditText


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvtodos = findViewById(R.id.lvTodos)
        btnAddTodo = findViewById(R.id.btnAddTodo)
        etNewTodo = findViewById(R.id.etNewTodo)

        val todoAdapter = ArrayAdapter<Todo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            todos
        )

        val db = MyDbHelper(this).writableDatabase

        fun refreshTodoList(){
            val todoList = TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(todoList)
            todoAdapter.notifyDataSetChanged()
        }

        lvtodos.adapter = todoAdapter
        refreshTodoList()

        btnAddTodo.setOnClickListener {
            val newTodo = Todo(
                etNewTodo.text.toString(),
                false
            )
            TodoTable.insertTodo(db,newTodo)
            refreshTodoList()
        }




    }
}