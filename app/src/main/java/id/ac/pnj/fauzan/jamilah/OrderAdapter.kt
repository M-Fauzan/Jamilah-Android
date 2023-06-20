package id.ac.pnj.fauzan.jamilah

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.pnj.fauzan.jamilah.databinding.ItemRowOrderBinding
// This class will be used later

class OrderAdapter() : RecyclerView.Adapter<OrderAdapter.ListViewAdapter>() {
    class ListViewAdapter(var binding: ItemRowOrderBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapter {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListViewAdapter, position: Int) {
        TODO("Not yet implemented")
    }
}