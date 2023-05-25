package com.example.plugins

import com.example.dao.dao
import com.example.dao.daoCampo
import com.example.models.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureRouting() {
    routing {
        // ...
        get("/") {
            call.respondRedirect("articles")
        }
        route("articles") {
            get {
                call.respond(FreeMarkerContent("indexArticle.ftl", mapOf("articles" to dao.allArticles())))
            }
            get("new") {
                call.respond(FreeMarkerContent("newArticle.ftl", model = null))
            }
            post {
                val formParameters = call.receiveParameters()
                val title = formParameters.getOrFail("title")
                val body = formParameters.getOrFail("body")
                val article = dao.addNewArticle(title, body)
                call.respondRedirect("/articles/${article?.id}")
            }
            get("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("showArticle.ftl", mapOf("article" to dao.article(id), "campos" to daoCampo.camposPorArticleId(id))))
            }
            get("{id}/edit") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("editArticle.ftl", mapOf("article" to dao.article(id))))
            }
            post("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "update" -> {
                        val title = formParameters.getOrFail("title")
                        val body = formParameters.getOrFail("body")
                        dao.editArticle(id, title, body)
                        call.respondRedirect("/articles/$id")
                    }
                    "delete" -> {
                        dao.deleteArticle(id)
                        call.respondRedirect("/articles")
                    }
                }
            }
        }
        route("campos") {
            get {
                call.respond(FreeMarkerContent("indexCampo.ftl", mapOf("campos" to daoCampo.allCampos())))
            }

            get("new") {
                call.respond(FreeMarkerContent("newCampo.ftl", mapOf("articles" to dao.allArticles())))
            }
            post {
                val formParameters = call.receiveParameters()
                val value = formParameters.getOrFail("value")
                val name = formParameters.getOrFail("name")
                val description = formParameters.getOrFail("description")
                val seasonId = formParameters.getOrFail("seasonId")
                val order = formParameters.getOrFail<Int>("order").toInt()
                val sectionId = formParameters.getOrFail<Int>("sectionId").toInt()
                val campo = daoCampo.addNewCampo(value, name, description, seasonId, order, sectionId)
                call.respondRedirect("/campos/${campo?.id}")
            }

            get("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("showCampo.ftl", mapOf("campo" to daoCampo.campo(id))))
            }
            get("{id}/edit") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("editCampo.ftl", mapOf("campo" to daoCampo.campo(id), "articles" to dao.allArticles())))
            }
            post("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "update" -> {
                        val value = formParameters.getOrFail("value")
                        val name = formParameters.getOrFail("name")
                        val description = formParameters.getOrFail("description")
                        val seasonId = formParameters.getOrFail("seasonId")
                        val order = formParameters.getOrFail("order").toInt()
                        val sectionId = formParameters.getOrFail("sectionId").toInt()
                        daoCampo.editCampo(id, value, name, description, seasonId, order, sectionId)
                        call.respondRedirect("/campos/$id")
                    }
                    "delete" -> {
                        daoCampo.deleteCampo(id)
                        call.respondRedirect("/campos")
                    }
                }
            }
        }
    }
}
