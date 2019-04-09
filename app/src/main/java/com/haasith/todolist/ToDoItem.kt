package com.haasith.todolist

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class  ToDoItem(var n: String? = "",
                     var i: Boolean? = null): RealmObject(){
    @PrimaryKey
    private var id = UUID.randomUUID().toString()
    public var name = ""
    public var important = false


    constructor(name: String, important: Boolean) : this() {
        this.name = name
        this.important = important
    }

    fun getID():String{
        return id
    }

    public override fun toString(): String {
        return name
    }
}