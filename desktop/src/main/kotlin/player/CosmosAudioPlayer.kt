package org.kotpot.cosmos.desktop.player

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.goxr3plus.streamplayer.enums.Status
import com.goxr3plus.streamplayer.stream.StreamPlayer
import com.goxr3plus.streamplayer.stream.StreamPlayerEvent
import com.goxr3plus.streamplayer.stream.StreamPlayerListener

class CosmosAudioPlayer : StreamPlayer(), StreamPlayerListener {

    private var _currentPosition by mutableStateOf(0f)
    val currentPosition = _currentPosition

    private var _currentPositionInMicro: Long by mutableStateOf(0)
    val currentPositionInMicro = _currentPositionInMicro

    private var _playerStatus by mutableStateOf(Status.NOT_SPECIFIED)
    val playerStatus = _playerStatus

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
        _currentPosition =
            if (nEncodedBytes > 0 && totalBytes > 0) nEncodedBytes * 1.0f / totalBytes * 1.0f else -1.0f
        _currentPositionInMicro = microsecondPosition / 1000
    }

    override fun statusUpdated(event: StreamPlayerEvent) {
        _playerStatus = event.playerStatus ?: Status.NOT_SPECIFIED
    }
}