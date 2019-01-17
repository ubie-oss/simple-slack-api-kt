package com.ullink.slack.simpleslackapi

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