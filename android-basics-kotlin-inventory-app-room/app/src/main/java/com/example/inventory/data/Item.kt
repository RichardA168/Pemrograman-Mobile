package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

//entity data class merepresentasikan satu baris yang ada dalam database
@Entity
data class Item(

    //room generate ID untuk setiap entity
    @PrimaryKey(autoGenerate = true)

    //deklarasi id, itemName, itemPrice, dan quantityInStock
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val itemName: String,
    @ColumnInfo(name = "price")
    val itemPrice: Double,
    @ColumnInfo(name = "quantity")
    val quantityInStock: Int,
)

fun Item.getFormattedPrice(): String =
    NumberFormat.getCurrencyInstance().format(itemPrice)