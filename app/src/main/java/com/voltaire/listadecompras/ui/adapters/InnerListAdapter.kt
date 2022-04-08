package com.voltaire.listadecompras.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.voltaire.listadecompras.R
import com.voltaire.listadecompras.database.models.Item
import com.voltaire.listadecompras.database.models.MarketListWithItems

class InnerListAdapter(private var itemsList : List<Item>,
                       private val listener : InnerAdapterCallBacks
) : RecyclerView.Adapter<InnerListAdapter.InnerListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerListViewHolder {
        return InnerListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InnerListViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun setItems(itemLists: List<Item>) {
        itemsList = itemLists
        notifyDataSetChanged()
    }

    inner class InnerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var btnIGotItem: Button = itemView.findViewById(R.id.btn_iGot)
        private var btnDeleteItem: Button = itemView.findViewById(R.id.btn_exlude_item)

        fun bind(marketListWithItems: Item) {

            btnIGotItem.setOnClickListener {
                listener.onItemIGot(itemsList[adapterPosition])

            }
            btnDeleteItem.setOnClickListener{
                listener.onItemDelete(itemsList[adapterPosition])
            }
        }
    }
}