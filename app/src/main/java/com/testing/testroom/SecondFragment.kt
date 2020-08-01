package com.testing.testroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.testing.testroom.database.AppDatabase
import com.testing.testroom.database.User
import kotlinx.android.synthetic.main.fragment_second.view.*
import kotlinx.android.synthetic.main.recycler_item.view.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {

            Thread{
                AppDatabase.getInstant(this.activity!!.application).userDao().insertAll(
                    User(view.editText_id.text.toString().toInt(),
                        view.editText_first_name.text.toString(),
                        view.editText_last_name.text.toString()
                    )
                )
            }.start()


            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

        }
    }
}