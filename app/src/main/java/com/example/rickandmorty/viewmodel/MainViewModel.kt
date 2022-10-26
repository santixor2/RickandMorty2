package com.example.rickandmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.model.CharacterRepository
import com.example.rickandmorty.util.ResultState
import kotlinx.coroutines.launch

class MainViewModel(private val repository: CharacterRepository): ViewModel(){
     private var _characterResultState = MutableLiveData<ResultState<Any>>()
     val characterResultState : LiveData<ResultState<Any>> get() = _characterResultState

    init {
        load()
    }

    private fun load(){
        viewModelScope.launch {
            repository.getCharacter().collect(){resultState ->
                _characterResultState.value = resultState
            }
        }
    }
}