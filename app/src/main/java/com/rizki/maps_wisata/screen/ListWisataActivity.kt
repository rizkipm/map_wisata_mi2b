package com.rizki.maps_wisata.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rizki.maps_wisata.R
import com.rizki.maps_wisata.adapter.AdapterWisata
import com.rizki.maps_wisata.model.ModelWisata

class ListWisataActivity : AppCompatActivity() {

    private  var  rv_listwisata : RecyclerView? = null
    private var wisataAdapter: AdapterWisata? = null
    private var wisataList = mutableListOf<ModelWisata>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)
        rv_listwisata = findViewById(R.id.rv_listwisata) as RecyclerView

        wisataList = ArrayList()
        wisataAdapter = AdapterWisata(wisataList)

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        rv_listwisata!!.layoutManager = layoutManager
        rv_listwisata!!.adapter = wisataAdapter

        prepareWisataList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareWisataList() {
        var itemWisata = ModelWisata(
            "Istano Pagaruyung",
            "Pagaruyung, Batusangkar",
            R.drawable.gambar1,
            "Istano Pagaruyung",
            -0.4712964,
            100.61883
        )
        wisataList.add(itemWisata)
        itemWisata = ModelWisata(
            "Istano Pagaruyung2",
            "Pagaruyung, Batusangkar2",
            R.drawable.gambar2,
            "Istano Pagaruyung2",
            -0.4712964,
            100.61883
        )
        itemWisata = ModelWisata(
            "Istano Pagaruyung3",
            "Pagaruyung, Batusangkar3",
            R.drawable.gambar3,
            "Istano Pagaruyung2",
            -0.4712964,
            100.61883
        )
        wisataList.add(itemWisata)

        itemWisata = ModelWisata(
            "Istano Pagaruyung4",
            "Pagaruyung, Batusangkar4",
            R.drawable.gambar4,
            "Istano Pagaruyung4",
            -0.4712964,
            100.61883
        )
        wisataList.add(itemWisata)
        itemWisata = ModelWisata(
            "Istano Pagaruyung5",
            "Pagaruyung, Batusangkar5",
            R.drawable.gambar5,
            "Istano Pagaruyung5",
            -0.4712964,
            100.61883
        )
        wisataList.add(itemWisata)


        wisataAdapter!!.notifyDataSetChanged()
    }
}