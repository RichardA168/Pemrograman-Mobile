package com.example.inventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.launch

//sebuah view model untuk menyimpan referensi ke dalam repository dan up-to-date kan semua item
class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {

    //cache atau menyimpan item dari database menggunakan LiveData
    val allItems: LiveData<List<Item>> = itemDao.getItems().asLiveData()

    //bersifat true jika stock item tersedia untuk dijual
    fun isStockAvailable(item: Item): Boolean {
        return (item.quantityInStock > 0)
    }

    //meng-update item yang ada ke dalam database
    fun updateItem(
        itemId: Int,
        itemName: String,
        itemPrice: String,
        itemCount: String
    ) {
        val updatedItem = getUpdatedItemEntry(itemId, itemName, itemPrice, itemCount)
        updateItem(updatedItem)
    }

    //me-launch coroutine baru untuk update sebuah item dengan cara non-blocking
    private fun updateItem(item: Item) {
        viewModelScope.launch {
            itemDao.update(item)
        }
    }

    //digunakan untuk mengurangi stock 1 unit dan meng-update nya di database
    fun sellItem(item: Item) {
        if (item.quantityInStock > 0) {
            // Decrease the quantity by 1
            val newItem = item.copy(quantityInStock = item.quantityInStock - 1)
            updateItem(newItem)
        }
    }

    //insert item baru ke dalam database
    fun addNewItem(itemName: String, itemPrice: String, itemCount: String) {
        val newItem = getNewItemEntry(itemName, itemPrice, itemCount)
        insertItem(newItem)
    }

    //me-launch coroutine baru untuk insert sebuah item dengan cara non-blocking
    private fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }
    }

    //me-launch coroutine baru untuk hapus sebuah item dengan cara non-blocking
    fun deleteItem(item: Item) {
        viewModelScope.launch {
            itemDao.delete(item)
        }
    }

     //mengambil item dari repository
    fun retrieveItem(id: Int): LiveData<Item> {
        return itemDao.getItem(id).asLiveData()
    }

    //bersifat true jika EditTexts terisi
    fun isEntryValid(itemName: String, itemPrice: String, itemCount: String): Boolean {
        if (itemName.isBlank() || itemPrice.isBlank() || itemCount.isBlank()) {
            return false
        }
        return true
    }

    //mengembalikan instansi entitas class Item dengan informasi yang dikirim dari user
    //akan digunakan sebagai jalan masuk ke inventory database
    private fun getNewItemEntry(itemName: String, itemPrice: String, itemCount: String): Item {
        return Item(
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = itemCount.toInt()
        )
    }

    //untuk meng-update yang telah diinput user ke dalam inventory database
    private fun getUpdatedItemEntry(
        itemId: Int,
        itemName: String,
        itemPrice: String,
        itemCount: String
    ): Item {
        return Item(
            id = itemId,
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = itemCount.toInt()
        )
    }
}

//factory class untuk menginisiasi instance ViewModel
class InventoryViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}