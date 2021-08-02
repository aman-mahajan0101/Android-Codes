package com.example.todolist_sqlite.db

data class Todo(var task : String, var done : Boolean) {

    @Override
    override fun toString(): String {
        return this.task
    }
}