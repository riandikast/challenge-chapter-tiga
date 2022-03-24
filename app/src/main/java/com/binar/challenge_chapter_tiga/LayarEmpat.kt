package com.binar.challenge_chapter_tiga

import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_layar_empat.*
import kotlinx.android.synthetic.main.fragment_layar_empat.view.*
import kotlinx.android.synthetic.main.fragment_layar_tiga.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LayarEmpat : Fragment() {
    @Parcelize
    data class Parcel(
        val usia: String,
        val alamat: String,
        val pekerjaan: String,

        ) : Parcelable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        val view = inflater.inflate(R.layout.fragment_layar_empat, container, false)
        val editText1 = view.findViewById<EditText>(R.id.screenusia)
        val editText2 = view.findViewById<EditText>(R.id.screenalamat)
        val editText3 = view.findViewById<EditText>(R.id.screenpekerjaan)
        val confirm = view.findViewById<Button>(R.id.backtoscreen3)

        val textWatcher = object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                val usiaC = screenusia.text.toString().trim()
                val alamatC = screenalamat.text.toString().trim()

                val pekerjaanC = screenpekerjaan.text.toString().trim()

                confirm.isEnabled =  usiaC.isNotEmpty() && alamatC.isNotEmpty() && pekerjaanC.isNotEmpty()


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
        editText2.addTextChangedListener(textWatcher)
        editText3.addTextChangedListener(textWatcher)

        confirm.backtoscreen3.setOnClickListener {
            val x = "20"
            val dataV = Parcel(screenusia.text.toString(),screenalamat.text.toString(),screenpekerjaan.text.toString())
            val nama = arguments?.getString("amount")
            val bund = Bundle()
            bund.putString("amount", nama)
            bund.putString("x", x)
            bund.putParcelable("parcelable", dataV)
            view.findNavController().navigate(R.id.action_layarEmpat_to_layarTiga, bund)

        }



        return view
    }



}