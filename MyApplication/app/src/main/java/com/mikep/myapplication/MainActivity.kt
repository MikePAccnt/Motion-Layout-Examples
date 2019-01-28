package com.mikep.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mikep.myapplication.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    var value : Int? = null
        get() {
            return 1
        }
        set(value) {
            if(value != null)
                field = value + 1
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
