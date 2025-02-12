package com.example.discbot.objects

import io.github.cdimascio.dotenv.dotenv

object Constants {
    val DISCORD_BOT_TOKEN = dotenv()["DISCORD_BOT_TOKEN"]
    val GUILD_ID = 1338441906442731592
    val WELCOME_CHANNEL_ID = 1339099801844977674
}