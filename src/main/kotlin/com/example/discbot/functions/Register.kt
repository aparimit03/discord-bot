package com.example.discbot.functions

import com.example.discbot.objects.Constants
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.rest.builder.interaction.integer

suspend fun registerCommands(kord: Kord){
    deleteGuildCommands(kord)
    deleteGlobalChatCommands(kord)
    kord.createGlobalChatInputCommand(
        "sum", "Adds two Numbers"
    ) {
        integer("first_number", "The first operand") {
            required = true
        }
        integer("second_number", "The second operand") {
            required = true
        }
    }
    println("Commands registered successfully")
}

suspend fun deleteGuildCommands(kord: Kord){
    val existingCommands = kord.rest.interaction.getGuildApplicationCommands(
        kord.resources.applicationId,
        Snowflake(Constants.GUILD_ID)
    )
    existingCommands.forEach { command ->
        kord.rest.interaction.deleteGuildApplicationCommand(kord.resources.applicationId, Snowflake(Constants.GUILD_ID), command.id)
        println("Deleted old guild command: ${command.name}")
    }
}

suspend fun deleteGlobalChatCommands(kord: Kord){
    val existingCommands = kord.rest.interaction.getGlobalApplicationCommands(kord.resources.applicationId)
    existingCommands.forEach { command ->
        kord.rest.interaction.deleteGlobalApplicationCommand(kord.resources.applicationId, command.id)
        println("Deleted old chat command: ${command.name}")
    }
}