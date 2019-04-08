package com.haasith.todolist

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import io.realm.Realm
import io.realm.kotlin.where

class FinishToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_to_do)
        val realm =  Realm.getDefaultInstance()
        var textView = findViewById<TextView>(R.id.finishText)
        var button = findViewById<Button>(R.id.completeButton)
        val id = intent.getStringExtra("Item")

        val todoItem = realm.where(ToDoItem::class.java).equalTo("id",id).findFirst()

        if (todoItem != null) {
            textView.text = todoItem.name
            if(todoItem.important){
                textView.setTypeface(Typeface.DEFAULT_BOLD)
            }
        }

        button.setOnClickListener {
            realm.beginTransaction()
            if (todoItem != null) {
                todoItem.deleteFromRealm()
            }
            realm.commitTransaction()
            finish()
        }


    }
}
