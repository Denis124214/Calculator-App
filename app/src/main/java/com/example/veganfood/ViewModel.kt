package com.example.veganfood
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class ViewModel : ViewModel() {
    private val cartItems = MutableLiveData<List<Description>>()

    init {
            if (cartItems.value == null) {
                cartItems.value = emptyList()
            }
    }

    fun getCartItems(): LiveData<List<Description>> {
        return cartItems
    }

    fun addToCart(cartItem: Description) {

        val currentItems = cartItems.value.orEmpty().toMutableList()
        currentItems.add(cartItem)
        cartItems.value = currentItems
        Log.d("ViewModel", "Item added to cart: $cartItem")
    }
}
