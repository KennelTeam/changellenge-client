package com.kennelteam.hack_change.ui.flow.post_flow

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.fragment.findNavController
import com.kennelteam.hack_change.databinding.FragmentPostFlowBinding
import com.kennelteam.hack_change.ui.flow.Post
import com.kennelteam.hack_change.R

class PostFlowFragment : Fragment() {

    private lateinit var postFlowViewModel: PostFlowViewModel
    private var _binding: FragmentPostFlowBinding? = null

    private var postList = ArrayList<Post>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadPosts()

        postFlowViewModel = ViewModelProvider(this)[PostFlowViewModel::class.java]

        _binding = FragmentPostFlowBinding.inflate(inflater, container, false)

        val root: View = binding.root

        val postListViewAdapter = context?.let { PostListViewAdapter(postList, it) }

        binding.postsListView.adapter = postListViewAdapter

        binding.postsListView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, itemIndex, _->
            this.findNavController().navigate(R.id.action_postFlowFragment_to_postFragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadPosts() {
        for (i in 0..10) {
            postList.add(Post(
                i,
                "UserName $i",
                "post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i " +
                        "post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i" +
                        "post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i post text $i"))
        }
    }

}