package com.example.musicplayermehdisheykhi

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var isPlay = true
    private val musicPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val img_play: ImageView = findViewById(R.id.img_play)
        val imgForward:ImageView = findViewById(R.id.img_forward)
        val imgBackward:ImageView = findViewById(R.id.img_backward)

        try {
            musicPlayer.setDataSource("https://dl.vmusic.ir/2020/09/Yanni%20The%20Essential/320k/18)%20Yanni%20-%20Into%20The%20Deep%20Blue%20-%202019.mp3")

        }
        catch (e:Exception){
            Toast.makeText(this, "Error in download music", Toast.LENGTH_SHORT).show()
        }
        musicPlayer.prepare()

        img_play.setOnClickListener {

            if (isPlay) {
                musicPlayer.start()
                img_play.setImageResource(R.drawable.pauseicon)
                isPlay = false
            }
            else{
                musicPlayer.pause()
                img_play.setImageResource(R.drawable.playicon)
                isPlay = true
            }
        }

        imgForward.setOnClickListener {
            musicPlayer.seekTo(musicPlayer.currentPosition + 3000)
            Toast.makeText(this, "+3s", Toast.LENGTH_SHORT).show()
        }
        imgBackward.setOnClickListener {
            musicPlayer.seekTo(musicPlayer.currentPosition - 3000)
            Toast.makeText(this, "-3s", Toast.LENGTH_SHORT).show()
        }
    }


}