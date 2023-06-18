package com.example.richardlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var secondAdapter: SecondAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        adapter = ItemAdapter(getItemList(), object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(item: Item) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("name", item.name)
                    putExtra("image", item.image)
                    putExtra("description", item.description)
                }
                startActivity(intent)
            }
        })

        secondAdapter = SecondAdapter(getItemList2(), object : SecondAdapter.OnItemClickListener {
            override fun onItemClick(item: Item2) {
                val intent = Intent(this@MainActivity, DetailActivity2::class.java).apply {
                    putExtra("name", item.name)
                    putExtra("image", item.image)
                    putExtra("description", item.description)
                }
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.beverage -> {
                    recyclerView.adapter = adapter
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dessert -> {
                    recyclerView.adapter = secondAdapter
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }


    private fun getItemList(): List<Item> {
        val items = mutableListOf<Item>()
        items.add(
            Item(
                "Cendol",
                R.drawable.cendol,
                getString(R.string.bevdesc_1),
                "Indonesian Beverage"
            )
        )
        items.add(
            Item(
                "Chocolate Milkshake",
                R.drawable.chocolatemilkshake,
                getString(R.string.bevdesc_2),
                "American Beverage"
            )
        )
        items.add(
            Item(
                "Thai tea",
                R.drawable.thaitea,
                getString(R.string.bevdesc_3),
                "Thailand Beverage"
            )
        )
        items.add(
            Item(
                "Lemonade",
                R.drawable.lemonade,
                getString(R.string.bevdesc_4),
                "Unknown Region Beverage"
            )
        )
        items.add(
            Item(
                "Mango Lassi",
                R.drawable.mangolassi,
                getString(R.string.bevdesc_5),
                "Indian Beverage"
            )
        )
        items.add(
            Item(
                "Shikuwasa Juice",
                R.drawable.shikuwasajuice,
                getString(R.string.bevdesc_6),
                "Japanese Beverage"
            )
        )
        items.add(
            Item(
                "Sangria",
                R.drawable.sangria,
                getString(R.string.bevdesc_7),
                "Spain Beverage"
            )
        )
        return items
    }

    private fun getItemList2(): List<Item2> {
        val items = mutableListOf<Item2>()
        items.add(
            Item2(
                "American Pie",
                R.drawable.americanpie,
                getString(R.string.dessDesc_1),
                "American dessert"
            )
        )
        items.add(
            Item2(
                "Baklava",
                R.drawable.baklava,
                getString(R.string.dessDesc_2),
                "Turkish dessert"
            )
        )
        items.add(
            Item2(
                "Pisang Goreng",
                R.drawable.pisanggoreng,
                getString(R.string.dessDesc_3),
                "Indonesian dessert"
            )
        )
        items.add(
            Item2(
                "Picarones",
                R.drawable.picarones,
                getString(R.string.dessDesc_4),
                "Peruvian dessert"
            )
        )
        items.add(
            Item2(
                "Tarta de Santiago",
                R.drawable.tartadesantiago,
                getString(R.string.dessDesc_5),
                "Spanish dessert"
            )
        )
        items.add(
            Item2(
                "Mochi",
                R.drawable.mochi,
                getString(R.string.dessDesc_6),
                "Japanese dessert"
            )
        )
        items.add(
            Item2(
                "Bomboloni",
                R.drawable.bomboloni,
                getString(R.string.dessDesc_7),
                "Italian dessert"
            )
        )
        items.add(
            Item2(
                "Brigaderos",
                R.drawable.brigaderos,
                getString(R.string.dessDesc_8),
                "Brazilian dessert"
            )
        )
        items.add(
            Item2(
                "Waffle",
                R.drawable.waffle,
                getString(R.string.dessDesc_9),
                "French dessert"
            )
        )
        items.add(
            Item2(
                "Lamingtons",
                R.drawable.lamingtons,
                getString(R.string.dessDesc_10),
                "Australian dessert"
            )
        )
        items.add(
            Item2(
                "Syrniki",
                R.drawable.syrniki,
                getString(R.string.dessDesc_11),
                "Russian dessert"
            )
        )
        items.add(
            Item2(
                "Princess Cake",
                R.drawable.princesscake,
                getString(R.string.dessDesc_12),
                "Swedian dessert"
            )
        )
        items.add(
            Item2(
                "Makowiec",
                R.drawable.makowiec,
                getString(R.string.dessDesc_13),
                "Polandian dessert"
            )
        )
        items.add(
            Item2(
                "Umm Ali",
                R.drawable.ummali,
                getString(R.string.dessDesc_14),
                "Egyptian dessert"
            )
        )
        items.add(
            Item2(
                "Black Forest Cherry Torte",
                R.drawable.blackforestcherrytorte,
                getString(R.string.dessDesc_15),
                "German dessert"
            )
        )
        return items
    }
}