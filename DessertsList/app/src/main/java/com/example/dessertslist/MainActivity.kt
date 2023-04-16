package com.example.dessertslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<dessert>

    lateinit var image : Array<Int>
    lateinit var heading : Array<String>
    lateinit var subheading : Array<String>
    lateinit var dessDesc : Array<String>

    lateinit var image2 : Array<Int>
    lateinit var heading2 : Array<String>
    lateinit var subheading2 : Array<String>
    lateinit var drinkDesc : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = arrayOf(
            R.drawable.americanpie,
            R.drawable.baklava,
            R.drawable.pisang_goreng,
            R.drawable.picarones,
            R.drawable.tarta_de_santiago,
            R.drawable.mochi,
            R.drawable.bomboloni,
            R.drawable.brigaderos,
            R.drawable.waffle,
            R.drawable.lamingtons,
            R.drawable.syrniki,
            R.drawable.princess_cake,
            R.drawable.makowiec,
            R.drawable.ummali,
            R.drawable.black_forest_cherry_torte
        )

        heading = arrayOf(
            getString(R.string.nameDess_1),
            getString(R.string.nameDess_2),
            getString(R.string.nameDess_3),
            getString(R.string.nameDess_4),
            getString(R.string.nameDess_5),
            getString(R.string.nameDess_6),
            getString(R.string.nameDess_7),
            getString(R.string.nameDess_8),
            getString(R.string.nameDess_9),
            getString(R.string.nameDess_10),
            getString(R.string.nameDess_11),
            getString(R.string.nameDess_12),
            getString(R.string.nameDess_13),
            getString(R.string.nameDess_14),
            getString(R.string.nameDess_15)
        )

        subheading = arrayOf(
            getString(R.string.subDess_1),
            getString(R.string.subDess_2),
            getString(R.string.subDess_3),
            getString(R.string.subDess_4),
            getString(R.string.subDess_5),
            getString(R.string.subDess_6),
            getString(R.string.subDess_7),
            getString(R.string.subDess_8),
            getString(R.string.subDess_9),
            getString(R.string.subDess_10),
            getString(R.string.subDess_11),
            getString(R.string.subDess_12),
            getString(R.string.subDess_13),
            getString(R.string.subDess_14),
            getString(R.string.subDess_15)
        )

        dessDesc = arrayOf(
            getString(R.string.dessDesc_1),
            getString(R.string.dessDesc_2),
            getString(R.string.dessDesc_3),
            getString(R.string.dessDesc_4),
            getString(R.string.dessDesc_5),
            getString(R.string.dessDesc_6),
            getString(R.string.dessDesc_7),
            getString(R.string.dessDesc_8),
            getString(R.string.dessDesc_9),
            getString(R.string.dessDesc_10),
            getString(R.string.dessDesc_11),
            getString(R.string.dessDesc_12),
            getString(R.string.dessDesc_13),
            getString(R.string.dessDesc_14),
            getString(R.string.dessDesc_15)
        )

        image2 = arrayOf(
            R.drawable.shikuwasa_juice,
            R.drawable.pastis,
            R.drawable.cider,
            R.drawable.chocolate_milkshake,
            R.drawable.cendol,
            R.drawable.mango_lassi,
            R.drawable.sujeonnggwa,
            R.drawable.sangria,
            R.drawable.eggnog,
            R.drawable.sake,
            R.drawable.lemonade,
            R.drawable.thaitea,
            R.drawable.tequila,
            R.drawable.raki,
            R.drawable.caipirinha
        )

        heading2 = arrayOf(
            getString(R.string.nameDrink_1),
            getString(R.string.nameDrink_2),
            getString(R.string.nameDrink_3),
            getString(R.string.nameDrink_4),
            getString(R.string.nameDrink_5),
            getString(R.string.nameDrink_6),
            getString(R.string.nameDrink_7),
            getString(R.string.nameDrink_8),
            getString(R.string.nameDrink_9),
            getString(R.string.nameDrink_10),
            getString(R.string.nameDrink_11),
            getString(R.string.nameDrink_12),
            getString(R.string.nameDrink_13),
            getString(R.string.nameDrink_14),
            getString(R.string.nameDrink_15)
        )

        subheading2 = arrayOf(
            getString(R.string.subDrink_1),
            getString(R.string.subDrink_2),
            getString(R.string.subDrink_3),
            getString(R.string.subDrink_4),
            getString(R.string.subDrink_5),
            getString(R.string.subDrink_6),
            getString(R.string.subDrink_7),
            getString(R.string.subDrink_8),
            getString(R.string.subDrink_9),
            getString(R.string.subDrink_10),
            getString(R.string.subDrink_11),
            getString(R.string.subDrink_12),
            getString(R.string.subDrink_13),
            getString(R.string.subDrink_14),
            getString(R.string.subDrink_15)
        )

        drinkDesc = arrayOf(
            getString(R.string.dessDesc_1),
            getString(R.string.dessDesc_2),
            getString(R.string.dessDesc_3),
            getString(R.string.dessDesc_4),
            getString(R.string.dessDesc_5),
            getString(R.string.dessDesc_6),
            getString(R.string.dessDesc_7),
            getString(R.string.dessDesc_8),
            getString(R.string.dessDesc_9),
            getString(R.string.dessDesc_10),
            getString(R.string.dessDesc_11),
            getString(R.string.dessDesc_12),
            getString(R.string.dessDesc_13),
            getString(R.string.dessDesc_14),
            getString(R.string.dessDesc_15)
        )

        newRecyclerView = findViewById(R.id.recycleView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<dessert>()
        getUserData()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.kue -> {
                    val adapter = DessertAdapter(newArrayList)
                    newRecyclerView.adapter = adapter
                    adapter.setOnItemClickListener(object : DessertAdapter.OnItemClickListener{
                        override fun onItemClick(position: Int) {

                            val intent = Intent(this@MainActivity,SecondActivity::class.java)
                            intent.putExtra("heading",newArrayList[position].heading)
                            intent.putExtra("image",newArrayList[position].image)
                            intent.putExtra("detail",dessDesc[position])
                            startActivity(intent)
                        }
                    })
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.minuman -> {
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }


    }

    private fun getUserData() {

        for (d in image.indices){
            val dessert = dessert(image[d],heading[d],subheading[d])
            newArrayList.add(dessert)
        }

        val adapter = DessertAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : DessertAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity,SecondActivity::class.java)
                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("image",newArrayList[position].image)
                intent.putExtra("detail",dessDesc[position])
                startActivity(intent)
            }
        })

    }
}