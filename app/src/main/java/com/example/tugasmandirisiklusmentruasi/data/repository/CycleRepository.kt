package com.example.tugasmandirisiklusmentruasi.data.repository

import com.example.tugasmandirisiklusmentruasi.DailyLog
import com.example.tugasmandirisiklusmentruasi.DatabaseHelper
import com.example.tugasmandirisiklusmentruasi.data.api.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CycleRepository(private val dbHelper: DatabaseHelper) {

    fun getDailyLogs(): Flow<List<DailyLog>> = flow {
        // 1. Tampilkan data dari SQLite (lokal) segera
        val localData = dbHelper.getAllDailyLogs()
        emit(localData)

        try {
            // 2. Jalankan request API di latar belakang
            val response = RetrofitInstance.api.getDailyLogs()
            if (response.isSuccessful) {
                val remoteData = response.body()
                if (remoteData != null) {
                    // 3. Simpan data baru dari API ke SQLite
                    remoteData.forEach { log ->
                        dbHelper.saveDailyLog(log.date, log.flow, log.symptoms, log.moods, log.medicine, log.note)
                    }
                    // Update tampilan dengan data terbaru dari database
                    emit(dbHelper.getAllDailyLogs())
                }
            }
        } catch (e: Exception) {
            // 4. Jika gagal: tetap tampilkan data SQLite yang sudah ada (sudah dilakukan di awal)
        }
    }

    suspend fun saveLog(log: DailyLog) {
        // 5. Setiap operasi tulis dikerjakan di keduanya (API + SQLite)
        dbHelper.saveDailyLog(log.date, log.flow, log.symptoms, log.moods, log.medicine, log.note)
        try {
            RetrofitInstance.api.saveDailyLog(log)
        } catch (e: Exception) {
            // Log error or handle retry later
        }
    }
}
