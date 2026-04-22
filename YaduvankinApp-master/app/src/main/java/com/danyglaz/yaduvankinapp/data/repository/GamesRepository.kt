package com.danyglaz.yaduvankinapp.data.repository

//import com.danyglaz.yaduvankinapp.data.dto.GameApiResponseDto
import android.util.Log
import com.danyglaz.yaduvankinapp.data.dto.GameItemDto
import com.danyglaz.yaduvankinapp.data.util.toModel
import com.danyglaz.yaduvankinapp.domain.model.GameItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun loadGames(): List<GameItem> {
        return try {
            val response = httpClient.get("get-all-games") {
                parameter("category", "technology")
            }.body<List<GameItemDto>>()
            return response.map{it.toModel()}
        } catch (e: Exception){
            Log.e("MY_APP_ERROR", "ПОЛНЫЙ ТЕКСТ ОШИБКИ: ", e)
            throw e
        }


    }
}
