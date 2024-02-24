package com.akashkamati.controllers.routes

import com.akashkamati.controllers.serializers.SendEmailRequestData
import com.akashkamati.controllers.serializers.SendEmailResponse
import com.akashkamati.domain.repo.MainRepo
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.sendEmailRoutes(mainRepo: MainRepo){
    
    post("send-email") {
        val requestData = call.receiveNullable<SendEmailRequestData>()
            ?: return@post call.respond(
                HttpStatusCode.BadRequest,
                SendEmailResponse(
                    status = 400,
                    success = false,
                    message = "Missing request params"
                )
            )
        val responseData = mainRepo.sendEmail(requestData)
        call.respond(
            if (responseData.success) HttpStatusCode.OK else HttpStatusCode.BadRequest,
            responseData
        )
    }

}