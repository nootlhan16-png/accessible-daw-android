package com.example.daw

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    
    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var isRecording = false
    private var audioFile: File? = null
    
    private lateinit var recordBtn: Button
    private lateinit var playBtn: Button
    private lateinit var stopBtn: Button
    private lateinit var statusText: TextView
    
    private val PERMISSION_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        recordBtn = findViewById(R.id.recordBtn)
        playBtn = findViewById(R.id.playBtn)
        stopBtn = findViewById(R.id.stopBtn)
        statusText = findViewById(R.id.statusText)
        
        recordBtn.setOnClickListener { startRecording() }
        playBtn.setOnClickListener { playAudio() }
        stopBtn.setOnClickListener { stopRecording() }
        
        checkPermissions()
    }
    
    private fun checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.RECORD_AUDIO
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.RECORD_AUDIO),
                    PERMISSION_REQUEST_CODE
                )
            }
        }
    }
    
    private fun startRecording() {
        try {
            audioFile = File(cacheDir, "audio_${System.currentTimeMillis()}.m4a")
            
            mediaRecorder = MediaRecorder().apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                setOutputFile(audioFile!!.absolutePath)
                prepare()
                start()
            }
            
            isRecording = true
            statusText.text = "🔴 Recording..."
            recordBtn.isEnabled = false
            playBtn.isEnabled = false
        } catch (e: Exception) {
            statusText.text = "Error: ${e.message}"
        }
    }
    
    private fun stopRecording() {
        try {
            if (isRecording) {
                mediaRecorder?.stop()
                mediaRecorder?.release()
                mediaRecorder = null
                isRecording = false
                statusText.text = "✅ Recording stopped"
                recordBtn.isEnabled = true
                playBtn.isEnabled = true
            }
        } catch (e: Exception) {
            statusText.text = "Error: ${e.message}"
        }
    }
    
    private fun playAudio() {
        try {
            if (audioFile != null && audioFile!!.exists()) {
                mediaPlayer = MediaPlayer().apply {
                    setDataSource(audioFile!!.absolutePath)
                    prepare()
                    start()
                }
                statusText.text = "▶️ Playing..."
            } else {
                statusText.text = "No recording found"
            }
        } catch (e: Exception) {
            statusText.text = "Error: ${e.message}"
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        mediaRecorder?.release()
        mediaPlayer?.release()
    }
}