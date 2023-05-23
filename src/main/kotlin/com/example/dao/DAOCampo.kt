package com.example.dao

import com.example.models.*

interface DAOCampo {
    suspend fun allCampos(): List<Campo>
    suspend fun campo(id: Int): Campo?
    suspend fun addNewCampo(value: String, name: String, description: String, seasonId: String, order: Int, sectionId : Int): Campo?
    suspend fun editCampo(id: Int, value: String, name: String, description: String, seasonId: String, order: Int, sectionId : Int): Boolean
    suspend fun deleteCampo(id: Int): Boolean
}