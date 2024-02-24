package com.akashkamati.data.email

interface EmailService {
    suspend fun sendEmail(data: EmailData):Boolean
}