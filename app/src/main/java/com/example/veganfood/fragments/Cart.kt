package com.example.veganfood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.veganfood.DescAdapter
import com.example.veganfood.Description
import com.example.veganfood.R
import com.example.veganfood.ViewModel

class Cart : Fragment() {
    lateinit var cartViewModel: ViewModel
    var price = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        cartViewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java)
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val menu = view.findViewById<ImageButton>(R.id.menu)
        val catalogue = view.findViewById<ImageButton>(R.id.catalogue)
        val plus = view.findViewById<ImageButton>(R.id.VeganPlusBtn)

        val reView: RecyclerView = view.findViewById(R.id.cartReView)

        menu.setOnClickListener {
            controller.navigate(R.id.menuPage)
        }

        catalogue.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }

        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        reView.layoutManager = layoutManager

        // Создайте и установите ваш адаптер
        val itemList: List<Description> = listOf(

            // Добавьте сколько угодно объектов Description с разными данными
        )
        val adapter = DescAdapter(cartViewModel.getCartItems().value.orEmpty(), cartViewModel)
        reView.adapter = adapter


    }
}
