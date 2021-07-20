package com.arpit.stackexchangeapi

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun questions(){
        runBlocking {
            val response = questionsService.apiService.getQuestions(1, 20 , 1626739200)
            assertNotNull(response.body())
        }

    }
}