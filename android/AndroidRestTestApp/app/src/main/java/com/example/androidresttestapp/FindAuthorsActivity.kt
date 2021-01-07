package com.example.androidresttestapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidresttestapp.databinding.ActivityFindAuthorsBinding
import com.example.androidresttestapp.model.Author
import com.example.androidresttestapp.service.AuthorManager

class FindAuthorsActivity : AppCompatActivity(), AuthorManager.GetAuthorCallback {

    private val authorsList = ArrayList<Author>()
    private lateinit var authorsAdapter:AuthorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFindAuthorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val authorTest = Author(11, "test")
        authorsList.add(authorTest)
        authorsAdapter = AuthorAdapter(this, authorsList)
        binding.foundAuthorsListView.adapter = authorsAdapter

        binding.searchButton.setOnClickListener {
            val like: String = binding.searchNameEdit.text.toString()
            authorsList.clear()
            authorsAdapter.notifyDataSetChanged()
            AuthorManager.getAuthors(like, this)
        }

    }

    override fun onResponse(authors: List<Author>) {
        authorsList.clear()
        authorsList.addAll(authors)
        authorsAdapter.notifyDataSetChanged()
    }

    override fun onFailure(error: String) {
        Toast.makeText(this, "$error", Toast.LENGTH_SHORT).show()
    }


    private class AuthorAdapter(context: Context, authorsList: List<Author>) :
        ArrayAdapter<Author>(context, R.layout.found_author, authorsList) {

        override fun getView(position: Int, viewOrNull: View?, viewGroup: ViewGroup): View {
            var view = viewOrNull

            if (view == null) {
                val inflater = LayoutInflater.from(context)
                view = inflater.inflate(R.layout.found_author, viewGroup, false)

            }

            val author = getItem(position)
            val label = view!!.findViewById<TextView>(R.id.found_author_label)
            val txt = author?.name ?: ""
            label.text = txt
            return view
        }

    }
}
