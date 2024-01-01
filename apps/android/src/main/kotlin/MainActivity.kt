package org.kotpot.cosmos

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import com.kotpot.cosmos.network.KrpcServiceCreator
import kotlinx.coroutines.launch
import org.kotpot.cosmos.pb.test.model.Platform
import org.kotpot.cosmos.ui.BlackButton

class MainActivity: AppCompatActivity() {

    private val state = mutableStateOf("")
    private val service = KrpcServiceCreator.testService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(
                modifier = Modifier.background(Color.White).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(state.value)

                BlackButton("Request") {
                    update()
                }
            }

        }
    }

    private fun update() {
        lifecycleScope.launch {
            val platform = Platform(
                "Android",
                "Null"
            )
            val resp = service.platform(platform)
            state.value = resp.toString()
        }
    }
}