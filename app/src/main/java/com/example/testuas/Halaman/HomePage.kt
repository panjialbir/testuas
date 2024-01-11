package com.example.testuas.Halaman

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.testuas.R
import com.example.testuas.data.LC
import com.example.testuas.data.OrderRoom
import com.example.testuas.model.OrderRoomViewModel
import com.example.testuas.repository.OfflineRepositoryOrder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomePage {
    private lateinit var orderRoomViewModel: OrderRoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        // Inisialisasi komponen-komponen
        val repositoryOrder = OfflineRepositoryOrder(komponen1, komponen2, komponen3)
        orderRoomViewModel = ViewModelProvider(this, OrderRoomViewModel.Factory(repositoryOrder))
            .get(OrderRoomViewModel::class.java)

        // Button untuk order room
        btnOrderR\oom.setOnClickListener {
            orderRoom()
        }

        // Button untuk tambah data LC
        btnAddLC.setOnClickListener {
            addLC()
        }

        // TODO: Tambahkan logika atau inisialisasi tampilan sesuai kebutuhan
    }

    private fun orderRoom() {
        // Contoh: Menambahkan data order room
        val newOrder = OrderRoom(
            namaPelanggan = "John Doe",
            tanggalSewa = "2022-01-01",
            durasiSewaJam = 2,
            hargaTotal = 50.0
        )

        GlobalScope.launch {
            orderRoomViewModel.tambahpenyewaan(newOrder)
        }

        // TODO: Tambahkan logika atau navigasi sesuai kebutuhan setelah order room
    }

    private fun addLC() {
        // Contoh: Menambahkan data LC
        val newLC = LC(lcname = "VIP Room")

        GlobalScope.launch {
            orderRoomViewModel.insertLC(newLC)
        }

        // TODO: Tambahkan logika atau notifikasi sesuai kebutuhan setelah menambahkan LC
    }
}
