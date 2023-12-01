package com.example.veganfood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.veganfood.R

class Cart : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val menu = view.findViewById<ImageButton>(R.id.menu)
        val catalogue = view.findViewById<ImageButton>(R.id.catalogue)

        menu.setOnClickListener {
            controller.navigate(R.id.menuPage)
        }

        catalogue.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }
    }
}