package com.akashkamati.di

import com.akashkamati.AppSecrets
import com.akashkamati.data.email.DefaultEmailService
import com.akashkamati.data.email.EmailService
import com.akashkamati.data.repo.MainRepoImpl
import com.akashkamati.domain.repo.MainRepo
import org.koin.dsl.module
import org.simplejavamail.api.mailer.Mailer
import org.simplejavamail.api.mailer.config.TransportStrategy
import org.simplejavamail.mailer.MailerBuilder

val mainModule = module {

    single<Mailer> {
        MailerBuilder
            .withSMTPServer(AppSecrets.SMTP_SERVER_HOST, AppSecrets.SMTP_SERVER_PORT)
            .withTransportStrategy(TransportStrategy.SMTP_TLS)
            .withSMTPServerUsername(AppSecrets.SMTP_SERVER_USER_NAME)
            .withSMTPServerPassword(AppSecrets.SMTP_SERVER_PASSWORD)
            .buildMailer()
    }

    single<EmailService> {
        DefaultEmailService(
            mailer = get<Mailer>()
        )
    }

    single<MainRepo>{
        MainRepoImpl(
            emailService = get<EmailService>()
        )
    }

}