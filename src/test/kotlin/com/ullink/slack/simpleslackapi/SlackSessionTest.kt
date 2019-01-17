package com.ullink.slack.simpleslackapi

import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

class SlackSessionTest {

    private val session: SlackSession = spyk()

    @Nested
    inner class Connect {
        @Test
        fun `no connect() call if isConnected is true`() {
            every { session.isConnected } returns true
            session.connect { }
            verify(exactly = 0) { session.connect() }
        }

        @Test
        fun `connect() call if isConnected is false`() {
            every { session.isConnected } returns false
            session.connect { it.isConnected }
            verify(exactly = 1) { session.connect() }
        }

        @Test
        fun `disconnect call`() {
            every { session.isConnected } returns true
            session.connect { }
            verify(exactly = 1) { session.disconnect() }
        }

        @Test
        fun `disconnect call even if throw Exception in block`() {
            every { session.isConnected } returns true
            try {
                session.connect { throw RuntimeException() }
            } catch (e: Exception) {
                // empty
            }
            verify(exactly = 1) { session.disconnect() }
        }
    }
}