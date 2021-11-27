package com.kennelteam.hack_change.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.kennelteam.hack_change.databinding.FragmentHomeBinding
import com.kennelteam.hack_change.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonCreatePost = binding.buttonCreatePost
        buttonCreatePost.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_start_create_post)
        }

        val buttonUserPage = binding.buttonTestUserPage
        buttonUserPage.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_show_user_page)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}