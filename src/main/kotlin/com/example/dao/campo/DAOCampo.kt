package com.example.dao.campo

import kotlinx.coroutines.runBlocking

val daoCampo: DAOCampoInterface = DAOCampoImpl().apply {
    runBlocking {
        if (allCampos().isEmpty()) {
            addNewCampo("YEPA", "Ya estoy", "por aquí no podía dejar mi", "stream", 33, 1)
        }
    }
}