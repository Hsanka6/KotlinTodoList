package com.haasith.todolist

import android.app.Application
import io.realm.Realm

public class ToDoApplication: Application(){
    public override fun onCreate() {
        super.onCreate()
        Realm.init(this);
    }
}