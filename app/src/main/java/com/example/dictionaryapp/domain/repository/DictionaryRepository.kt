package com.example.dictionaryapp.domain.repository


import com.example.dictionaryapp.domain.model.WordItem
import com.example.dictionaryapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
     fun getWordResult(word: String): Flow<Resource<WordItem>>
}


//interface DictionaryRepository {
//    suspend fun getWordResult(
//        word: String
//    ): Flow<Result<WordItem>>
//}

