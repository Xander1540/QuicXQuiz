package com.example.quicxquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quicxquiz.databinding.ActivityQuizBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var list:ArrayList<QuestionModel>
    private var count:Int = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList<QuestionModel>()

        Firebase.firestore.collection("QuicXQuiz")
            .get().addOnSuccessListener {
                doct->
                list.clear()
                for (i in doct.documents){

                    var questionModel= i.toObject(QuestionModel::class.java)
                    list.add(questionModel!!)
                }

                binding.question.setText(list.get(0).question)
                binding.a.setText(list.get(0).a)
                binding.b.setText(list.get(0).b)
                binding.c.setText(list.get(0).c)
                binding.d.setText(list.get(0).d)
            }




        binding.a.setOnClickListener{
            nextData(binding.a.text.toString())
        }
        binding.b.setOnClickListener {
            nextData(binding.a.text.toString())
        }
        binding.c.setOnClickListener {
            nextData(binding.a.text.toString())
        }
        binding.d.setOnClickListener {
            nextData(binding.a.text.toString())
        }
    }

    private fun nextData(i: String){
        if (count<list.size) {
            if (list.get(count).ans.equals(i)) {
                score++
            }
        }

        count++

        if (count>=list.size){

            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
            finish()

        }else {
            binding.question.setText(list.get(count).question)
            binding.a.setText(list.get(count).a)
            binding.b.setText(list.get(count).b)
            binding.c.setText(list.get(count).c)
            binding.d.setText(list.get(count).d)
        }

    }

}

