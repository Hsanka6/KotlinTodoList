package com.haasith.todolist

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class  ToDoItem: RealmObject(){
    @PrimaryKey
    private var id = UUID.randomUUID().toString()
    public var name = ""
    public var important = false

    fun getID():String{
        return id
    }

    public override fun toString(): String {
        return name
    }
}