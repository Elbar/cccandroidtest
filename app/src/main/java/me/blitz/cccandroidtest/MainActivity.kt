package me.blitz.cccandroidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import me.blitz.cccandroidtest.db.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}