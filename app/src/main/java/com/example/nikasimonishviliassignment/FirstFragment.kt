package com.example.nikasimonishviliassignment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.nikasimonishviliassignment.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater,container,false)

        val sharedPref = this.activity?.getSharedPreferences("name", Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()

        binding.button2.setOnClickListener {
            val name = PersonName.text.toString()
            editor?.apply{
                putString(R.string.person_name.toString(),name)
                apply()
            }
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return binding.root

    }




}