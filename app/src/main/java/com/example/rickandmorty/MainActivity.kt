package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.util.ResultState
import com.example.rickandmorty.view.MainAdapter
import com.example.rickandmorty.viewmodel.MainViewModel
import com.example.rickandmorty.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel: MainViewModel by viewModels(factoryProducer = {MainViewModelFactory()})
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //rvMain()
        //suscribeMainAdapter()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
            as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)



    }
   /** private fun rvMain(){
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
    }**/
}