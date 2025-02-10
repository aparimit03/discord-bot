import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import `object`.Constants

suspend fun main() {
    val kord = Kord(Constants.DISCORD_BOT_TOKEN)

    kord.on<MessageCreateEvent> { // runs every time a message is created that our bot can read
        println("${message.author}\n${message.content}\n" +
                "${message.channel}")

        // ignore other bots, even ourselves. We only serve humans here!
        if (message.author?.isBot != false) return@on

        // check if our command is being invoked
        if (message.content != "!ping") return@on

        // all clear, give them the pong!
        println("msg ->" + message.content)
        message.channel.createMessage("pong!")
    }

    kord.login {
        // we need to specify this to receive the content of messages
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent
    }
}