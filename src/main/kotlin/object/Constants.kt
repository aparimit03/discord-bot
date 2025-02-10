package `object`

import io.github.cdimascio.dotenv.dotenv

object Constants {
    val DISCORD_BOT_TOKEN = dotenv()["DISCORD_BOT_TOKEN"]
}