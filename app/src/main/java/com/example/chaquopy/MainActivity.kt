package com.example.chaquopy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!Python.isStarted()){
            Python.start(AndroidPlatform(this))
        }

        val py = Python.getInstance()
        val pyObj = py.getModule("script")

        val btn = findViewById<Button>(R.id.btn_done)
        val num1 = findViewById<EditText>(R.id.et_num1)
        val num2 = findViewById<EditText>(R.id.et_num2)
        val result = findViewById<TextView>(R.id.tv_result)
        btn.setOnClickListener{
            val obj = pyObj.callAttr("main",
            num1.text.toString(),
                num2.text.toString())
            result.text = obj.toString()
        }
    }
}