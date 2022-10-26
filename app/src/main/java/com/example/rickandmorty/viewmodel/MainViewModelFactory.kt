package com.example.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.model.CharacterRemoteDataSource
import com.example.rickandmorty.model.CharacterRepository

class MainViewModelFactory: ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        val remoteDataSource = CharacterRemoteDataSource()
        val repository = CharacterRepository(remoteDataSource)
        return MainViewModel(repository) as T
    }
}