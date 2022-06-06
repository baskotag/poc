package com.poc.action

import com.poc.model.Movie

interface OnClickListener {
    fun  onclick(movie: Movie)
}