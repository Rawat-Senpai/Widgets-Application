package com.example.widgetsapplication.ui.akatsukiUi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.widgetsapplication.R
import com.example.widgetsapplication.databinding.FragmentAkatsukiBinding
import com.example.widgetsapplication.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AkatsukiFragment : Fragment() {

    private var _binding:FragmentAkatsukiBinding ?=null
    private val binding get() = _binding!!

    private val viewModel by viewModels<AkatsukiViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_akatsuki, container, false)


        _binding= FragmentAkatsukiBinding.inflate(inflater,container,false)


        viewModel.getAllAkatsukiMembers()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {

            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getAllAkatsukiMember.collect{
                    Log.d("checkingDataResponse",it.toString());
                    when(it){
                        is NetworkResult.Error -> {}
                        is NetworkResult.Loading ->  {}
                        is NetworkResult.Success ->  {}
                        null ->  {}
                    }
                }
            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}