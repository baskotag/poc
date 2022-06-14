package com.poc.utils
import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule

open class BaseUnitTest
{
    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
}