package com.akashkamati.plugins

import com.akashkamati.controllers.routes.sendEmailRoutes
import com.akashkamati.domain.repo.MainRepo
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val mainRepo by inject<MainRepo>()

    routing {
        sendEmailRoutes(mainRepo)
    }
}
