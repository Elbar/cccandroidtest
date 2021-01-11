package me.blitz.cccandroidtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.blitz.cccandroidtest.ui.main.MainFragment

class AppActivity : AppCompatActivity(R.layout.activity_app) {
    var mainFragment: MainFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        supportFragmentManager.beginTransaction().replace(R.id.container, mainFragment).commit()
    }
}