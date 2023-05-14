package com.example.latihanmvvmwithnewsapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanmvvmwithnewsapi.adapter.SourceAdapter
import com.example.latihanmvvmwithnewsapi.databinding.ActivitySourceBinding
import com.example.latihanmvvmwithnewsapi.viewmodel.SourceViewModel

class SourceActivity : AppCompatActivity() {
    lateinit var binding : ActivitySourceBinding
    lateinit var sourceAdapter: SourceAdapter
    lateinit var sourceVm : SourceViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sourceAdapter = SourceAdapter(ArrayList())

        sourceVm = ViewModelProvider(this).get(SourceViewModel::class.java)

        binding.rvSource.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val bundle = intent.extras
        val getCategory = bundle?.getString("name", "") ?: ""

        sourceVm.callApiSource(getCategory)
        binding.rvSource.adapter = sourceAdapter

        sourceVm.getDataSource().observe(this, Observer { list ->
            list?.let {
                sourceAdapter.setDataResouce(it)
            }
        })


        sourceAdapter.onClickso = { source ->
            val bundle = Bundle().apply {
                putString("source", source.name)
            }
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }


    }
}