package com.example.retrofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val repo = intent.getParcelableExtra<PostModel>("item")
        if (repo != null) {
            val nameView: TextView = findViewById(R.id.NameView)
            val fullNameView: TextView = findViewById(R.id.FullNameView)
            val visibilityView: TextView = findViewById(R.id.VisibilityView)
            val urlView: TextView = findViewById(R.id.UrlView)
            val idView: TextView = findViewById(R.id.IdView)

            nameView.text = "Name: ${repo.name}"
            fullNameView.text = "Full Name : ${repo.full_name}"
            visibilityView.text = "Visibility: ${repo.visibility}"
            urlView.text = "URL: ${repo.html_url}"
            idView.text = "Repo ID: ${repo.id.toString()}"
        }

    }
}