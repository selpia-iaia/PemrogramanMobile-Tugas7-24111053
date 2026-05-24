package com.example.tugasmandirisiklusmentruasi.data.api

import com.example.tugasmandirisiklusmentruasi.DailyLog
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("daily_logs.php")
    suspend fun getDailyLogs(): Response<List<DailyLog>>

    @POST("save_log.php")
    suspend fun saveDailyLog(@Body log: DailyLog): Response<Void>
}
