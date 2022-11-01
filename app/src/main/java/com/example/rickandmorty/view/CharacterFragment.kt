package com.example.rickandmorty.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.util.ResultState
import com.example.rickandmorty.viewmodel.MainViewModel
import com.example.rickandmorty.viewmodel.MainViewModelFactory

class CharacterFragment: Fragment(){

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels(factoryProducer = { MainViewModelFactory() })
    private lateinit var mainAdapter: MainAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMain()
        suscribeMainAdapter()
    }
    private fun rvMain(){
        mainAdapter = MainAdapter(listOf())
        binding.rvHome.apply {
            setHasFixedSize(true)
            //layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
            layoutManager = GridLayoutManager(context, 2)
            adapter = mainAdapter
        }

    }

    private fun setupMainAdapter(listCharacter : List<Characters>){
        binding.rvHome.adapter = MainAdapter(listCharacter)

    }
    private fun suscribeMainAdapter(){
        viewModel.characterResultState.observe(viewLifecycleOwner, Observer {resulstState ->
            when(resulstState){
                is ResultState.Loading ->{

                }
                is ResultState.Success ->{
                    val listCharacter = (resulstState.data as?  List<Characters>) ?: emptyList()
                    if (listCharacter.isNotEmpty()) setupMainAdapter(listCharacter)
                }
                is ResultState.Error ->{

                }
            }
        })
    }





}