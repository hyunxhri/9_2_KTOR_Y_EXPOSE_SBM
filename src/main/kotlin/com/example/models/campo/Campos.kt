package com.example.models.campo

import com.example.models.article.Articles
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object Campos : Table(){
    val id = integer("id").autoIncrement()
    val value = varchar("value2", 1024)
    val name = varchar("name", 128)
    val description = varchar("description", 256)
    val seasonId = varchar("seasonid", 32)
    val order = integer("orden")
    val sectionId = integer("sectionid").references(Articles.id, onDelete= ReferenceOption.CASCADE)
    override val primaryKey = PrimaryKey(id)
}