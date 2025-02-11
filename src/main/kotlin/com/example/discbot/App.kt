package com.example.discbot

import com.example.discbot.functions.listenToCommands
import com.example.discbot.functions.registerCommands
import com.example.discbot.objects.Constants
import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import kotlin.system.exitProcess

suspend fun main() {
    val kord: Kord = try {
        Kord(Constants.DISCORD_BOT_TOKEN).also {
            println("Bot Created")
        }
    } catch (e: Exception) {
        println("Error initializing bot: ${e.message}")
        exitProcess(1)
    }

    kord.let {
        registerCommands(it)
        listenToCommands(it)
        loginKord(it)
    }
}

@OptIn(PrivilegedIntent::class)
suspend fun loginKord(kord: Kord) {
    try {
        kord.login {
            intents += Intent.MessageContent
            intents += Intent.GuildMessages
            intents += Intent.DirectMessages
        }
    } catch (e: Exception) {
        println("Login failed: ${e.message}")
        exitProcess(1)
    }
}