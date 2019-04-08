package com.haasith.todolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_to_do.*

class AddToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title = "Add TODO"
        val realm =  Realm.getDefaultInstance()

        var button = findViewById<Button>(R.id.button)

        var checkBox = findViewById<CheckBox>(R.id.checkBox)


        var editText = findViewById<EditText>(R.id.editText);

        button.setOnClickListener {
            var d = ToDoItem()
            d.important = checkBox.isChecked
            d.name = editText.text.toString()
            realm.beginTransaction()
            realm.copyToRealm(d)
            realm.commitTransaction()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }



    }
}
