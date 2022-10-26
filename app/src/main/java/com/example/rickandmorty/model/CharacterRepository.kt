package com.example.rickandmorty.model

import com.example.rickandmorty.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepository(private val remoteDataSource: CharacterRemoteDataSource){
   suspend fun getCharacter(): Flow<ResultState<Any>> = flow {
       emit(ResultState.Loading())
       emit(remoteDataSource.getCharacter())
   }
}