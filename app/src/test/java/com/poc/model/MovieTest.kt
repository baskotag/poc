package com.poc.model

import junit.framework.TestCase
import org.junit.Test

class MovieUnitTest : TestCase() {

   @Test
    fun getAllMovies(){
       val movie=Movie("Bullet Train","https://www.imdb.com/title/tt12593682/mediaviewer/rm36704513/?ref_=tt_ov_i","Action","Five assassins aboard a fast moving bullet train find out their missions have something in common")

       assertEquals("Bullet Train",movie.name)
    }

    fun testTestGetName() {

    }

    fun testCopy() {}

    fun testDescribeContents() {}

    fun testWriteToParcel() {}
}