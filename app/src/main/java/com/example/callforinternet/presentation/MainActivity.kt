package com.example.callforinternet.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.callforinternet.R
import com.example.callforinternet.app.App
import com.example.callforinternet.data.repository.UserRepositoryImpl
import com.example.callforinternet.data.storage.SharedStorage
import com.example.callforinternet.data.storage.SharedUserStorage
import com.example.callforinternet.domain.model.SaveUserNameParam
import com.example.callforinternet.domain.usecase.GetUserUseCase
import com.example.callforinternet.domain.usecase.SaveUserUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainActivityViewModelFactory

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, vmFactory)[MainActivityViewModel::class.java]

        val dataTextView = findViewById<TextView>(R.id.tv1)
        val dataEditView = findViewById<EditText>(R.id.etData)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnGet = findViewById<Button>(R.id.btnGetData)

        viewModel.getDataLive.observe(this) {
            dataTextView.text = it
        }

        btnSave.setOnClickListener {
            val text = dataEditView.text.toString()
            viewModel.saveData(text)
        }

        btnGet.setOnClickListener {
            viewModel.getData()
        }
    }
}