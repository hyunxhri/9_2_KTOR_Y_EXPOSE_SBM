package com.example.dao

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Campo
import com.example.models.Campos
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOCampoImpl : DAOCampo {
    private fun resultRowToCampo(row: ResultRow) = Campo(
        id = row[Campos.id],
        value = row[Campos.value],
        name = row[Campos.name],
        description = row[Campos.description],
        seasonId = row[Campos.seasonId],
        order = row[Campos.order],
        sectionId = row[Campos.sectionId],
    )
    override suspend fun allCampos(): List<Campo> = dbQuery {
        Campos.selectAll().map(::resultRowToCampo)
    }

    override suspend fun campo(id: Int): Campo? = dbQuery {
        Campos
            .select { Campos.id eq id }
            .map(::resultRowToCampo)
            .singleOrNull()
    }

    override suspend fun camposPorArticleId(id: Int): List<Campo> = dbQuery {
        Campos
            .select { Campos.sectionId eq id }
            .map(::resultRowToCampo)
    }

    override suspend fun addNewCampo(
        value: String,
        name: String,
        description: String,
        seasonId: String,
        order: Int,
        sectionId: Int,
    ): Campo? = dbQuery {
        val insertStatement = Campos.insert {
            it[Campos.value] = value
            it[Campos.name] = name
            it[Campos.description] = description
            it[Campos.seasonId] = seasonId
            it[Campos.order] = order
            it[Campos.sectionId] = sectionId
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToCampo)
    }

    override suspend fun editCampo(
        id: Int,
        value: String,
        name: String,
        description: String,
        seasonId: String,
        order: Int,
        sectionId: Int,
    ): Boolean = dbQuery {
        Campos.update({ Campos.id eq id }) {
            it[Campos.value] = value
            it[Campos.name] = name
            it[Campos.description] = description
            it[Campos.seasonId] = seasonId
            it[Campos.order] = order
            it[Campos.sectionId] = sectionId
        } > 0
    }

    override suspend fun deleteCampo(id: Int): Boolean = dbQuery {
        Campos.deleteWhere { Campos.id eq id } > 0
    }
}
val daoCampo: DAOCampo = DAOCampoImpl().apply {
    runBlocking {
        if (allCampos().isEmpty()) {
            addNewCampo("YEPA", "Ya estoy", "por aquí no podía dejar mi", "stream", 33, 1)
        }
    }
}
