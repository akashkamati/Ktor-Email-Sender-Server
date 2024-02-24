package com.akashkamati.data.repo

import com.akashkamati.AppSecrets
import com.akashkamati.controllers.serializers.SendEmailRequestData
import com.akashkamati.controllers.serializers.SendEmailResponse
import com.akashkamati.data.email.EmailData
import com.akashkamati.data.email.EmailService
import com.akashkamati.domain.repo.MainRepo

class MainRepoImpl(
    private val emailService: EmailService
) : MainRepo {
    override suspend fun sendEmail(data: SendEmailRequestData): SendEmailResponse {
        val result = emailService.sendEmail(EmailData(
            emailTo = data.email,
            subject = data.subject,
            message = data.message,
            emailFrom = AppSecrets.EMAIL_FROM
        ))
        return SendEmailResponse(
            success = result,
            status = if (result) 200 else 400,
            message = if (result) "Successfully sent email" else "Failed to send email"
        )
    }
}