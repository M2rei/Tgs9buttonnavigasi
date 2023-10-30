package com.example.tgs9buttonnavigasi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tgs9buttonnavigasi.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var filmList: ArrayList<Film>
    private lateinit var filmAdapter: FilmAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val username = requireActivity().intent.getStringExtra(LoginActivity.EXTRA_NAME)

        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        filmList = ArrayList()

        filmList.add(Film(R.drawable.monkey, "The Monkey King"))
        filmList.add(Film(R.drawable.legion, "Legion of Super Heroes"))
        filmList.add(Film(R.drawable.elephant, "The Magician's Elephant"))
        filmList.add(Film(R.drawable.marioo, "The Super Mario Bros. Movie"))
        filmList.add(Film(R.drawable.evil, "Resident Evil: Death Island"))
        filmList.add(Film(R.drawable.nimona, "Nimona"))

        filmAdapter = FilmAdapter(filmList)
        recyclerView.adapter = filmAdapter

        filmAdapter.onItemClick = {
            val intentToDetailActivity = Intent(requireActivity(), DetailActivity::class.java)
            intentToDetailActivity.putExtra("film", it)
            intentToDetailActivity.putExtra(LoginActivity.EXTRA_NAME, username)
            startActivity(intentToDetailActivity)
        }

        binding.tkshome2.text = username
    }


}