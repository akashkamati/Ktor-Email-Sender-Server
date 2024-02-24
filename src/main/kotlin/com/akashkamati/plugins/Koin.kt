package com.akashkamati.plugins

import com.akashkamati.di.mainModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.koin

fun Application.configureKoin(){
    koin {
        modules(mainModule)
    }
}