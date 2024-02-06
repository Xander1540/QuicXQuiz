package com.example.quicxquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.quicxquiz.ui.login.LoginActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({

            if(Firebase.auth.currentUser!=null) {
                val intent = Intent(this, QuizActivity::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("MODE", "SIGNUP")
                startActivity(intent)
            }
        },3000)

    }
}