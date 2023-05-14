package com.example.latihanmvvmwithnewsapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanmvvmwithnewsapi.R
import com.example.latihanmvvmwithnewsapi.adapter.CategoryAdapter
import com.example.latihanmvvmwithnewsapi.databinding.ActivityCategoryBinding
import com.example.latihanmvvmwithnewsapi.model.Category

class CategoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listCategory = arrayListOf(
            Category("BUSINESS", R.drawable.business),
            Category("ENTERTAINMENT", R.drawable.entertainment),
            Category("GENERAL", R.drawable.general),
            Category("HEALTH", R.drawable.health),
            Category("SCIENCE", R.drawable.science),
            Category("SPORTS", R.drawable.sports),
            Category("TECHNOLOGY", R.drawable.technology)
        )

        categoryAdapter = CategoryAdapter(listCategory)

        binding.rvCategory.apply {
            layoutManager =
                LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
            categoryAdapter.onClick = {
                var categ = it.name
                val inten = Intent(context, SourceActivity::class.java)
                inten.putExtra("name", categ)
                startActivity(inten)
            }
        }


    }
}