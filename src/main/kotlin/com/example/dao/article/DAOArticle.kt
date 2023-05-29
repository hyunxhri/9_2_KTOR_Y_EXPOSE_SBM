package com.example.dao.article
import kotlinx.coroutines.runBlocking

val dao: DAOArticleInterface = DAOArticleImpl().apply {
    runBlocking {
        if(allArticles().isEmpty()) {
            addNewArticle("The drive to develop!", "...it's what keeps me going.")
        }
    }
}