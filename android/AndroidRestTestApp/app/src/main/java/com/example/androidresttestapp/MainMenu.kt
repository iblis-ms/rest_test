package com.example.androidresttestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidresttestapp.databinding.ActivityMainBinding
import com.example.androidresttestapp.model.Author
import com.example.androidresttestapp.repository.QuotationServiceAPI
import com.example.androidresttestapp.repository.ServiceBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(QuotationServiceAPI::class.java)
        val call = request.getAuthors()

        call.enqueue(object : Callback<List<Author>> {
            override fun onResponse(call: Call<List<Author>>, response: Response<List<Author>>) {
                if (response.isSuccessful) {

                    val res = response.body()!!.joinToString {
                        it.name
                    }
                    print(res)
                }
            }
            override fun onFailure(call: Call<List<Author>>, t: Throwable) {
                Toast.makeText(this@MainMenu, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
