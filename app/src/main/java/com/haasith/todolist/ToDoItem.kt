package com.haasith.todolist

import io.realm.RealmObject

open class  Item: RealmObject(){
    public var name = ""
    public var important = false


    public override fun toString(): String {
        return name
    }
}