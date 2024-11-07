package com.example.recyclerviewpict

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewpict.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan generatePictures, membuat instance adapter,
        // dan diatur ke RecyclerView
        val pictureList = generatePictures()
        val adapterPicture = PictureAdapter(pictureList)

        // Mengatur RecyclerView pada rvPicture
        with(binding) {
            rvPicture.apply {
                adapter = adapterPicture
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Membuat daftar objek Picture yang akan ditampilkan
    private fun generatePictures() : List<Picture> {
        return listOf(
            Picture(R.drawable.baseline_backpack_24, "Backpack"),
            Picture(R.drawable.baseline_chair_24, "Chair"),
            Picture(R.drawable.baseline_directions_car_24, "Car"),
            Picture(R.drawable.baseline_home_24, "Home"),
            Picture(R.drawable.baseline_sports_motorsports_24, "Helmet"),
            Picture(R.drawable.baseline_table_restaurant_24, "Table"),
        )
    }
}