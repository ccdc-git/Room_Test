package com.testing.testroom

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testing.testroom.database.AppDatabase
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : RecyclerView.Adapter<*>
    private lateinit var layoutManager : RecyclerView.LayoutManager

    private val handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            setRecyclerView()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.recyclerView = view.recyclerView

        Thread {
            this.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
            this.adapter = MyAdapter(AppDatabase.getInstant(this.activity!!.application).userDao().getAll())
            handler.sendMessage(Message())
        }.start()

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun setRecyclerView() {
        recyclerView.apply {
            adapter = this@FirstFragment.adapter
            layoutManager = this@FirstFragment.layoutManager
            setHasFixedSize(true)
        }

    }
}