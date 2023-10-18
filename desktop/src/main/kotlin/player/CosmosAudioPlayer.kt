package org.kotpot.cosmos.desktop.player

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.goxr3plus.streamplayer.enums.Status
import com.goxr3plus.streamplayer.stream.StreamPlayer
import com.goxr3plus.streamplayer.stream.StreamPlayerEvent
import com.goxr3plus.streamplayer.stream.StreamPlayerListener

class CosmosAudioPlayer : StreamPlayer(), StreamPlayerListener {

    var currentPosition by mutableStateOf(0f)
        private set

    var currentPositionInMicro: Long by mutableStateOf(0)
        private set

    var playerStatus by mutableStateOf(Status.NOT_SPECIFIED)
        private set

    init {
        addStreamPlayerListener(this)
    }

    override fun opened(dataSource: Any?, properties: MutableMap<String, Any>?) {

    }

    override fun progress(
        nEncodedBytes: Int,
        microsecondPosition: Long,
        pcmData: ByteArray?,
        properties: MutableMap<String, Any>?
    ) {
        currentPosition =
            if (nEncodedBytes > 0 && totalBytes > 0) nEncodedBytes * 1.0f / totalBytes * 1.0f else -1.0f
        currentPositionInMicro = microsecondPosition / 1000
    }

    override fun statusUpdated(event: StreamPlayerEvent) {
        playerStatus = event.playerStatus ?: Status.NOT_SPECIFIED
    }
}