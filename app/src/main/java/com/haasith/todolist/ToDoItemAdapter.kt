package com.haasith.todolist

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ToDoItemAdapter(val context: Context, val result: HomeFeed) : RecyclerView.Adapter<ToDoItemAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("pos " + position)
        holder.binder(result.video.get(position), context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return result.video.count()
    }


    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        val taskName = itemView.findViewById<TextView>(R.id.todoItemView);
        val idName =itemView.findViewById<TextView>(R.id.idView);
        fun binder(tdi: Video, context:Context){
            taskName.text = tdi.name
            //println("counter is "+result.size)
            idName.text = tdi.id.toString()

        }


    }


}
