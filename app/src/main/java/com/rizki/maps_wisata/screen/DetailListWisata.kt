package com.rizki.maps_wisata.screen

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rizki.maps_wisata.R
import com.rizki.maps_wisata.databinding.ActivityMapsBinding

class DetailListWisata : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var txtJudul : TextView
    private lateinit var txtDeskripsi : TextView
    private lateinit var imgWisata : ImageView

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_list_wisata)

        txtJudul = findViewById(R.id.txtDetailNamaWisata)
        txtDeskripsi = findViewById(R.id.txtDetailDesk)
        imgWisata = findViewById(R.id.imgDetailGambarWisata)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_wisata) as SupportMapFragment
        mapFragment.getMapAsync(this)

        //        val txtDetail = getResources().getString(getIntent().getIntExtra("text", 0));
//        val imgDetail = getResources().getIntent().getIntExtra("image", 0);
        val imageResId = intent.getIntExtra("gambarWisata",0)
        val txtNamaWisata = intent.getStringExtra("namaLokasiWisata")
        val txtDeskWisata = intent.getStringExtra("deskWisata")
//        val detailSinopsi = intent.getStringExtra("sinopsis")

        Log.d("img nya", imageResId.toString())
        Log.d("teks detail nya", txtNamaWisata.toString())

        imgWisata.setImageResource(imageResId)
        txtJudul.text = txtNamaWisata
        txtDeskripsi.text = txtDeskWisata
//        txtSinopsis.text = detailSinopsi

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}