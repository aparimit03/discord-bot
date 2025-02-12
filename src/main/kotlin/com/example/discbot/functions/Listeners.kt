package com.example.discbot.functions

import com.example.discbot.objects.Constants
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.TextChannelBehavior
import dev.kord.core.behavior.createTextChannel
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.entity.channel.TextChannel
import dev.kord.core.event.guild.MemberJoinEvent
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.AttachmentBuilder
import kotlin.system.exitProcess

suspend fun kordListener(kord: Kord) {
    kord.on<MessageCreateEvent> {
        println("Message Received: ${message.content}")
    }

    kord.on<MemberJoinEvent> {
        val member = member
        val guild = member.getGuild()
        val message = "Welcome to the server ${member.mention}"

        val channel = try {
            guild.getChannel(Snowflake(Constants.WELCOME_CHANNEL_ID)) as TextChannel
        } catch (e: Exception) {
            println(e.message)
            exitProcess(1)
        }

        try {
            channel.createMessage(message)
        } catch (e: Exception) {
            println(e.message)
        }

        println("Message sent: $message")
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