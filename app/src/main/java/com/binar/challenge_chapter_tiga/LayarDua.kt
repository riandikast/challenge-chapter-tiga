package com.binar.challenge_chapter_tiga

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_layar_dua.*
import kotlinx.android.synthetic.main.fragment_layar_dua.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class LayarDua : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_layar_dua, container, false)
        view.gotoscreen3.setOnClickListener {

            val nama = screennama.text.toString()
            val bund = bundleOf("amount" to nama)
            view.findNavController().navigate(R.id.action_layarDua_to_layarTiga, bund)
        }


        val editText1 = view.findViewById<EditText>(R.id.screennama)
        val confirm = view.findViewById<Button>(R.id.gotoscreen3)

        val textWatcher = object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val nama = editText1.text.toString().trim()
                confirm.isEnabled = nama.isNotEmpty()


            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub
            }
        }


        editText1.addTextChangedListener(textWatcher)
        return view
    }}

