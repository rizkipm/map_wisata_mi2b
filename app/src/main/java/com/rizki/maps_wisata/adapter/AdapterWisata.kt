package com.rizki.maps_wisata.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rizki.maps_wisata.R
import com.rizki.maps_wisata.model.ModelWisata
import com.rizki.maps_wisata.screen.DetailListWisata
import com.rizki.maps_wisata.screen.ListWisataActivity

class AdapterWisata(
    private val wisataList: List<ModelWisata>,
    private val getActivity: ListWisataActivity,//untuk bisa d klik
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
        holder.itemView.setOnClickListener(){
            val intent = Intent(getActivity,
                DetailListWisata::class.java)

            //put text into a bundle and add to intent
            //put text into a bundle and add to intent
            intent.putExtra("namaLokasiWisata", wisataList[position].namaLokasiWisata)
            intent.putExtra("alamatWisata",wisataList[position].alamatWisata)
            intent.putExtra("gambarWisata",wisataList[position].gambarWisata)
            intent.putExtra("deskWisata",wisataList[position].deskWisata)
            intent.putExtra("latWisata",wisataList[position].latWisata)
            intent.putExtra("longWisata",wisataList[position].longWisata)

            getActivity.startActivity(intent)
        }
    }
}