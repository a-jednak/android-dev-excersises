package com.example.video_player

import android.net.Uri
import android.net.Uri.parse
import android.widget.VideoView
import android.widget.MediaController
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.video_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = findViewById<VideoView>(R.id.testView)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // Specify the location of video file
        val uri: Uri = parse("android.resource://$packageName/raw/index")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus() // allows the video to start immediately and focus on the controller
        videoView.start()

    }

}