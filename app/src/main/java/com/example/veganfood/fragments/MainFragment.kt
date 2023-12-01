package com.example.veganfood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.veganfood.DescAdapter
import com.example.veganfood.Description
import com.example.veganfood.R

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val menu = view.findViewById<ImageButton>(R.id.menu)
        val cart = view.findViewById<ImageButton>(R.id.cart)

        val reView : RecyclerView = view.findViewById(R.id.reView)
        // Создайте и установите менеджер макетов (например, LinearLayoutManager)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false)
        reView.layoutManager = layoutManager

        // Создайте и установите ваш адаптер
        val itemList: List<Description> = listOf (
            Description(R.drawable.veganshortcourse, R.drawable.plus, "Veggie burger", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),
            Description(R.drawable.vegan_jamaican_bowl, R.drawable.plus, "Vegan Jamaican", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),
            Description(R.drawable.catalogue, R.drawable.plus, "some_title", "some_subtitle"),
            // Добавьте сколько угодно объектов Description с разными данными
        )
        val adapter = DescAdapter(itemList)
        reView.adapter = adapter

        cart.setOnClickListener {
            controller.navigate(R.id.cartPage)
        }

        menu.setOnClickListener {
            controller.navigate(R.id.menuPage)
        }

    }
}