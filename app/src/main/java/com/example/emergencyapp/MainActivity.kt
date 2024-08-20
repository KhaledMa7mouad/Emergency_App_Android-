package com.example.emergencyapp

import android.app.Dialog
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.emergencyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val emergencies = arrayListOf<EmergencyModel>()
        emergencies.add(EmergencyModel(R.drawable.child,"Child Rescue","16000"))
        emergencies.add(EmergencyModel(R.drawable.police , "Emergency Police","122"))
        emergencies.add(EmergencyModel(R.drawable.fire,"Fire Department","180"))
        emergencies.add(EmergencyModel(R.drawable.emergency,"Ambulance","123"))
        emergencies.add(EmergencyModel(R.drawable.mental,"Mental Health","102"))
        emergencies.add(EmergencyModel(R.drawable.electric,"Elecrtic Emergency","121"))
        emergencies.add(EmergencyModel(R.drawable.internet,"Internet issue","1111"))

      val adapter= EmergencyAdapter(this ,emergencies)
        val rv : RecyclerView = findViewById(R.id.rv)
        rv.adapter = adapter

    }



}