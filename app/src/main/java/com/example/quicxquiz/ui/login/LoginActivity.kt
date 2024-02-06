package com.example.quicxquiz.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quicxquiz.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.login.setOnClickListener {

            val email = binding.email?.text.toString()
            val password = binding.password.text.toString()

            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful)
                    {
                        Toast.makeText(this, "User Created!!", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "User Not Created: ${it.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
