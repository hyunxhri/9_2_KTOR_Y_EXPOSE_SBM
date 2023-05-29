package com.example.models.article

import org.jetbrains.exposed.sql.*

data class Article(val id: Int, val title: String, val body: String)

