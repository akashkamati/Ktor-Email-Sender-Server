package com.akashkamati.controllers.serializers

import kotlinx.serialization.Serializable

@Serializable
data class SendEmailResponse(
    val status:Int,
    val success:Boolean,
    val message:String
)
