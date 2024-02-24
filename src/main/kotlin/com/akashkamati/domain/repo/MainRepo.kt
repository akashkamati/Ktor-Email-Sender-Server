package com.akashkamati.domain.repo

import com.akashkamati.controllers.serializers.SendEmailRequestData
import com.akashkamati.controllers.serializers.SendEmailResponse

interface MainRepo {
    suspend fun sendEmail(data:SendEmailRequestData):SendEmailResponse
}