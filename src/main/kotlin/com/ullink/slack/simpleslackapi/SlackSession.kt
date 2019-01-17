package com.ullink.slack.simpleslackapi

/**
 * Kotlin friendly syntax for connect/disconnect SlackSession
 *
 * Normally, SlackSession needs to call connect/disconnect like this
 * ```
 * session.connect()
 * val channel = session.findChannelByName("general")
 * session.sendMessage(channel, "hi im a bot" )
 * session.disconnect()
 * ```
 * Now, this method helps us write like this
 *
 * ```
 * session.connect {
 *     val channel = it.findChannelByName("general")
 *     it.sendMessage(channel, "hi im a bot" )
 * }
 * ```
 *
 */
fun <T> SlackSession.connect(block: (SlackSession) -> T): T {
    try {
        if (!isConnected) {
            connect()
        }
        return block(this)
    } finally {
        if (isConnected) {
            disconnect()
        }
    }
}