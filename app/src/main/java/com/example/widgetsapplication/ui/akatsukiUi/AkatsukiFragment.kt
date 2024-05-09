package com.example.widgetsapplication.ui.akatsukiUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.widgetsapplication.R
import com.example.widgetsapplication.databinding.FragmentAkatsukiBinding


class AkatsukiFragment : Fragment() {

    private var _binding:FragmentAkatsukiBinding ?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_akatsuki, container, false)


        _binding= FragmentAkatsukiBinding.inflate(inflater,container,false)


        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}