package com.example.rickandmorty.model

import android.util.Log
import com.example.rickandmorty.util.ResultState
import kotlin.math.E

class CharacterRemoteDataSource {
   suspend fun getCharacter(): ResultState<Any>{
        val service = RetrofitService
            .instance
            .create(ApiService::class.java)
            .getCharacter()

       return try {
            if (service.isSuccessful && service.body()?.personajes != null ){
                ResultState.Success(service.body()!!.personajes)
            }else{
                ResultState.Error(Exception(service.message()?:"Unknown error\""))
            }

        }
        catch (e : Exception){
            return ResultState.Error(Exception("May be you don´t have a connection to internet"))
        }

    }
}