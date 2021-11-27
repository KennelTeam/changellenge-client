package com.example.changellenge_client.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.changellenge_client.R
import com.example.changellenge_client.Variables
import com.example.changellenge_client.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val nickname: TextView = binding.textNickname
        nickname.setText(Variables.nickname)

        val profileImage: ImageView = binding.imageView

        val status_text = binding.textStatus
        status_text.setText(Variables.status)

        val edit_button: Button = binding.buttonEditProfile
        edit_button.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_edit_profile)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}