package com.example.examencoppel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examencoppel.databinding.ActivityContentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}