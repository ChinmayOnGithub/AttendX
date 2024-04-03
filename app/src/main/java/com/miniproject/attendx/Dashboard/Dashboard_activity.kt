package com.miniproject.attendx.Dashboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.miniproject.attendx.databinding.ActivityDashboardBinding

class Dashboard_activity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var data = arrayOf<String>("Try1", "Try2", "Try3", "Try4", "Try5", "Try6")
        binding.RecyclerView.adapter = RecyclerViewDashboard_Adapter(data)


        binding.drawerIconId.setOnClickListener {
//            val intentToOpenMenu = intent
        }


    }
}