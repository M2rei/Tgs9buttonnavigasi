package com.example.tgs9buttonnavigasi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tgs9buttonnavigasi.databinding.FragmentHomeBinding
import com.example.tgs9buttonnavigasi.databinding.FragmentProfilBinding

class ProfilFragment : Fragment(R.layout.fragment_profil) {
    private lateinit var binding: FragmentProfilBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfilBinding.bind(view)

        val usernamee = requireActivity().intent.getStringExtra(LoginActivity.EXTRA_NAME)


        binding.namaprifile.text = usernamee
    }

}