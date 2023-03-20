package com.example.richardsdiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Letak munculnya button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice() //Dadu akan me-roll saat aplikasi dimulai
    }
    //Atribut rollDice yang akan dipakai
    private fun rollDice() {
        //Membuat sebuah object dice dengan 6 sisi
        val dice = Dice(6)
        //Menjalankan sebuah dice
        val diceRoll = dice.roll()
        //Gambar dadu akan dimunculkan ke layar aplikasi
        val diceImage: ImageView = findViewById(R.id.imageView)
        //Perulangan seperti if..else dan menentukan gambar mana
        //yang akan muncul setelah mendapatkan angka acak
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Memunculkan gambar setelah mendapatkan angka acak
        diceImage.setImageResource(drawableResource)
        //Mengupdate deskripsi konten
        diceImage.contentDescription = diceRoll.toString()
    }
    //Kelas Dice
    class Dice(private val numSides: Int) {
        //Tempat dadu untuk mengambil nilai secara acak
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}
