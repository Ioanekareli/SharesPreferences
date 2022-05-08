package com.example.nikasimonishviliassignment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nikasimonishviliassignment.databinding.FragmentFirstBinding
import com.example.nikasimonishviliassignment.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var binding: FragmentSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater,container,false)

        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        val sharedPref = activity?.getSharedPreferences("name",Context.MODE_PRIVATE)
        val name = sharedPref?.getString(R.string.person_name.toString(),null)


        binding.textView2.setText(name)

        return binding.root

    }

}