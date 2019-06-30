package com.kuloglu.hungry

import com.kuloglu.hungry.utils.Validator
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

lateinit var validator: Validator
    @Before
    fun setup(){
        validator = Validator()
    }
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun ss (){
        assertFalse(validator.isEMailValid("mustaf@agmail.com"))
    }

    @Test
    fun tttt(){
        val mo = mock(Validator::class.java)

        mo?.isEMailValid("mustafagmail.com")?.let { assertFalse(it) }
    }
}
