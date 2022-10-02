package com.example.trf_task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Loginactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)
    }
    fun gotosignup(view: View){
        startActivity(Intent(this,signuppage:: class.java))
    }
    fun loginUser(view: View){
        startActivity(Intent(this,Loginpage:: class.java))
    }
    fun login(view: View){
        startActivity(Intent(this,Loginactivity:: class.java))
    }
}