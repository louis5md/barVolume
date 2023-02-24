package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.trimmedLength

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edWidth: EditText
    private lateinit var edHeight: EditText
    private lateinit var edLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLEKU", "onCreate: ")
        setContentView(R.layout.activity_main)
        edWidth = findViewById(R.id.edit_width)
        edHeight = findViewById(R.id.edit_height)
        edLength = findViewById(R.id.edit_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLEKU", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLEKU", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLEKU", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLEKU", "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLEKU", "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLEKU", "onDestroy: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }


    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_calculate){
            var isEmptyFields = false

            val inputLength = edLength.text.toString().trim()
            val inputWidth = edWidth.text.toString().trim()
            val inputHeight = edHeight.text.toString().trim()

            if(inputHeight.isEmpty()){
                isEmptyFields = true
                edHeight.error = "Field ini tidak boleh kosong"
            }

            if(inputLength.isEmpty()){
                isEmptyFields = true
                edLength.error = "Field ini tidak boleh kosong"
            }

            if(inputWidth.isEmpty()){
                isEmptyFields = true
                edWidth.error = "Field ini tidak boleh kosong"
            }
            if(!isEmptyFields){
                val volume = inputHeight.toDouble() * inputLength.toDouble() * inputWidth.toDouble()
                tvResult.text = volume.toString()
            }

        }
    }
}