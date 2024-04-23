package com.dicoding.meowpedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCats : RecyclerView
    private val list = ArrayList<Cat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCats = findViewById(R.id.rv_cats)
        rvCats.setHasFixedSize(true)

        list.addAll(getListCats())
        showRecycleList()
    }

    private fun getListCats(): ArrayList<Cat>{
        val dataName = resources.getStringArray(R.array.data_cat)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_picture)
        val listCat = ArrayList<Cat>()
        for (i in dataName.indices){
            val cat = Cat(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, - 1))
            listCat.add(cat)
        }
        return listCat
    }

    private fun showRecycleList() {
        rvCats.layoutManager = LinearLayoutManager(this)
        val listCatAdapter = ListCatAdapter(list)
        rvCats.adapter = listCatAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_profile -> {
                val moveIntent = Intent(this@MainActivity, MoveToProfile::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}