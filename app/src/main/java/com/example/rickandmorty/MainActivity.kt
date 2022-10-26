package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.util.ResultState
import com.example.rickandmorty.view.MainAdapter
import com.example.rickandmorty.viewmodel.MainViewModel
import com.example.rickandmorty.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels(factoryProducer = {MainViewModelFactory()})
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rvMain()
        suscribeMainAdapter()

    }
    private fun rvMain(){
        mainAdapter = MainAdapter(listOf())
        binding.rvHome.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
            adapter = mainAdapter
        }

    }
    private fun setupMainAdapter(listCharacter : List<Characters>){
        binding.rvHome.adapter = MainAdapter(listCharacter)

    }
    private fun suscribeMainAdapter(){
        viewModel.characterResultState.observe(this){resulstState ->
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
        }
    }
}