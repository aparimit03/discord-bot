package com.example.discbot.functions

import com.example.discbot.objects.Constants
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.interaction.GlobalChatInputCreateBuilder
import dev.kord.rest.builder.interaction.integer

suspend fun listenToCommands(kord: Kord) {
    kord.on<MessageCreateEvent> {
        println("Message Received: ${message.content}")
    }

    kord.on<ChatInputCommandInteractionCreateEvent> {
        if (interaction.invokedCommandName == "sum") {
            val firstNumber = interaction.command.integers["first_number"]!!.toInt()
            val secondNumber = interaction.command.integers["second_number"]!!.toInt()
            interaction.deferPublicResponse().respond {
                content = "The sum is ${firstNumber + secondNumber}"
            }
        }
    }
}