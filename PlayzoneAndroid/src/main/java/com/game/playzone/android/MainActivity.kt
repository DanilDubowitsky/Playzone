package com.game.playzone.android

import GamesRepository
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import di.Inject.instance
import io.ktor.util.reflect.instanceOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView1)

        val gamesRepository = instance<GamesRepository>()

        CoroutineScope(context = Dispatchers.IO).launch {
            val game = gamesRepository.fetchAllGames()
            with(Dispatchers.Main) {
                textView.text = "Game title: ${game.first().title}"
            }
        }
    }
}