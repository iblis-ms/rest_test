package com.example.androidresttestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
//
//        val request = ServiceBuilder.buildService(QuotationServiceAPI::class.java)
//        val call = request.getAuthors()
//
//        call.enqueue(object : Callback<List<Author>> {
//            override fun onResponse(call: Call<List<Author>>, response: Response<List<Author>>) {
//                if (response.isSuccessful) {
//
//                    val res = response.body()!!.joinToString {
//                        it.name
//                    }
//                    print(res)
//                }
//            }
//            override fun onFailure(call: Call<List<Author>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
    }
}
