package com.example.veganfood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veganfood.databinding.DescItemBinding

class DescAdapter(private val itemList: List<Description>) : RecyclerView.Adapter<DescAdapter.ViewHolder>() {

    class ViewHolder (item: View): RecyclerView.ViewHolder (item) { // class viewHolder. Каждый класс имеет сссылки на свои элементы
        val binding = DescItemBinding.bind(item) // PlantItemBinding.bind(item) используется для связывания элементов макета с объектами в коде.
        fun bind(desc: Description) { // можно здесь with(binding написать, чтобы не пришлось ниже binding писать
            binding.VeganImage.setImageResource(desc.ImageId)
            binding.VegunBtn.setImageResource(desc.ImageBtnId)
            binding.VeganTitle.text = desc.title // вроде понятно
            binding.VeganSuptitle.text = desc.suptitle

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DescItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
        // Bind your data to the ViewHolder's views here using currentItem
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    interface DescItemClickListener {
        fun onPlusButtonClick(description: Description)
    }

    private var descItemClickListener: DescItemClickListener? = null

    fun setDescItemClickListener(listener: DescItemClickListener) {
        this.descItemClickListener = listener
    }
}
