package com.testing.testroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testing.testroom.database.User
import kotlinx.android.synthetic.main.recycler_item.view.*

class MyAdapter(private val dataSet: List<User>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder (private val view : View) : RecyclerView.ViewHolder(view){
        fun bind(item : User){
            view.textView_user_code.text = item.userCode.toString()
            view.textView_user_id.text = item.uid.toString()
            val name = "${item.firstName} ${item.lastName}"
            view.textVeiw_user_name.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return this.dataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataSet[holder.adapterPosition]
        holder.bind(item)
    }

}