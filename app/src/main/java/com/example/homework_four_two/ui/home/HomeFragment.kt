package com.example.homework_four_two.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.homework_four_two.R
import com.example.homework_four_two.databinding.FragmentHomeBinding
import com.example.homework_four_two.model.Task
import com.example.homework_four_two.ui.home.adapter.TaskAdapter
import com.example.homework_four_two.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter = TaskAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(TaskFragment.TASK_REQUEST) { _,bundle ->
            val data = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
       //     Log.e("tag","onViewCrate:"+ data) для вывода на консоль
            adapter.setTask(data)
        }
        btnFab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}