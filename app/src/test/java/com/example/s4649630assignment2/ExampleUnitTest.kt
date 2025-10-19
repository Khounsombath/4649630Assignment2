package com.example.s4649630assignment2

import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class DashboardApiTest {

    private lateinit var api: DashboardApi

    @Before
    fun setup() {
        // Simulate what Hilt provides in AppModule but with longer timeouts
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://nit3213api.onrender.com/") // My API
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        api = retrofit.create(DashboardApi::class.java)
    }

    @Test
    fun `test dashboard API returns valid data`() = runBlocking {
        val response = api.dashboard("courses")

        // This line ensures network worked
        assertTrue("Response should be successful", response.isSuccessful)

        val body = response.body()
        assertNotNull("Body should not be null", body)
        assertTrue("Entities list should not be empty", body!!.entities.isNotEmpty())
    }
}
