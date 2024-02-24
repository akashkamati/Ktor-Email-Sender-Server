package com.akashkamati.data.email

import org.simplejavamail.api.mailer.Mailer
import org.simplejavamail.email.EmailBuilder

class DefaultEmailService(
    private val mailer: Mailer
) : EmailService {
    override suspend fun sendEmail(data: EmailData): Boolean {
        val userName = data.emailTo.split("@")[0]
        val email = EmailBuilder.startingBlank()
            .from("Your Email Username", data.emailFrom)
            .to(userName, data.emailTo)
            .withSubject(data.subject)
            .withPlainText(data.message)
            .buildEmail()
        return try {
            mailer.sendMail(email)
            true
        }catch (e:Exception){
            e.printStackTrace()
            false
        }
    }
}