package com.leessy.fluttermix

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.idlefish.flutterboost.containers.FlutterFragment
import com.leessy.fluttermix.flutterutil.PageRouter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        startActivity(Intent(this, FlutterActivity::class.java))
//        finish()
    }

    fun flutter1(view: View) {
        PageRouter.openPageByUrl(this, "first", null)
    }

    fun flutter2(view: View) {
        PageRouter.openPageByUrl(this, "second", null)
    }

    fun flutter3(view: View) {
        val mFragment: FlutterFragment =
            FlutterFragment.NewEngineFragmentBuilder().url("flutterbus://ViewWidget").build()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, mFragment)
            .commit()
    }

}