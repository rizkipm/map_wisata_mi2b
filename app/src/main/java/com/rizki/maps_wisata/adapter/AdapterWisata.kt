package com.rizki.maps_wisata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rizki.maps_wisata.R
import com.rizki.maps_wisata.model.ModelWisata

class AdapterWisata(
    private val wisataList: List<ModelWisata>,
) : RecyclerView.Adapter<AdapterWisata.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNamaWisata: TextView = itemView.findViewById(R.id.txtNamaLokasi)
        val txtAlamat: TextView = itemView.findViewById(R.id.txtAlamat)
        val imgWisata: ImageView = itemView.findViewById(R.id.imgWisata)
        val cardView: CardView = itemView.findViewById(R.id.cardWisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_wisata, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return wisataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = wisataList[position]
        holder.txtNamaWisata.text = currentItem.namaLokasiWisata
        holder.txtAlamat.text = currentItem.alamatWisata
        holder.imgWisata.setImageResource(currentItem.gambarWisata)
    }
}