package com.example.veganfood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.example.veganfood.R

class Menu : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val cart = view.findViewById<LinearLayout>(R.id.cartL)
        val catalogue= view.findViewById<LinearLayout>(R.id.catalogueL)
        val exit = view.findViewById<LinearLayout>(R.id.exitL)

        catalogue.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }

        cart.setOnClickListener {
            controller.navigate(R.id.cartPage)
        }

        exit.setOnClickListener {
            activity?.finish()
        }
    }
}