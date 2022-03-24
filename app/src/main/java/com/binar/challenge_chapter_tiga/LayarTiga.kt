package com.binar.challenge_chapter_tiga

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_layar_tiga.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LayarTiga : Fragment() {
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

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_layar_tiga, container, false)
        view.gotoscreen4.setOnClickListener {
            val nama = arguments?.getString("amount")
            val bund = bundleOf("amount" to nama)
            view.findNavController().navigate(R.id.action_layarTiga_to_layarEmpat, bund)

        }

        val pekerjaan= view.findViewById<TextView>(R.id.viewpekerjaan)
        val nama= view.findViewById<TextView>(R.id.viewnama)
        val usia= view.findViewById<TextView>(R.id.viewusia)
        val alamat= view.findViewById<TextView>(R.id.viewalamat)

        val profile = arguments?.getParcelable<LayarEmpat.Parcel>("parcelable")
        val x = arguments?.getString("x")

        pekerjaan.text = arguments?.getString("amount")
        pekerjaan.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35F)

        if (x == "20"){

            val intUsia = profile?.usia?.toInt()

            if (intUsia != null) {
                if (intUsia % 2 == 1 ) {
                        usia.text = profile.usia +", Bernilai Ganjil"
                }else{

                        usia.text = profile.usia +", Bernilai Genap"
                }
            }
            nama.text = arguments?.getString("amount")
            alamat.text = profile?.alamat
            pekerjaan.text = profile?.pekerjaan

            pekerjaan.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)

        }

        return view
    }



}