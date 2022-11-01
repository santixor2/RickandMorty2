package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
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