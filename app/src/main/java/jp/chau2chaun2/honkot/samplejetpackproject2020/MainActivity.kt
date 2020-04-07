package jp.chau2chaun2.honkot.samplejetpackproject2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main.FirstFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FirstFragment.newInstance())
                    .commitNow()
        }
    }
}
