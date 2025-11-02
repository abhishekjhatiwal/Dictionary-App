package com.example.dictionaryapp.data.repository

import android.app.Application
import com.example.dictionaryapp.R
import com.example.dictionaryapp.data.api.DictionaryApi
import com.example.dictionaryapp.data.mapper.toWordItem
import com.example.dictionaryapp.domain.model.WordItem
import com.example.dictionaryapp.domain.repository.DictionaryRepository
import com.example.dictionaryapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
) : DictionaryRepository {

    override  fun getWordResult(
        word: String
    ): Flow<Resource<WordItem>> {
        return flow {
            emit(Resource.Loading(true))

            val remoteWordResultDto = try {
                dictionaryApi.getWordResult(word)
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(application.getString(R.string.can_t_get_result)))
                emit(Resource.Loading(false))
                return@flow
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(application.getString(R.string.can_t_get_result)))
                emit(Resource.Loading(false))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(application.getString(R.string.can_t_get_result)))
                emit(Resource.Loading(false))
                return@flow
            }

            remoteWordResultDto?.let { wordResultDto ->
                wordResultDto[0]?.let { wordItemDto ->
                    emit(Resource.Success(wordItemDto.toWordItem()))
                    emit(Resource.Loading(false))
                    return@flow
                }
            }

            emit(Resource.Error(application.getString(R.string.can_t_get_result)))
            emit(Resource.Loading(false))
        }
    }
}