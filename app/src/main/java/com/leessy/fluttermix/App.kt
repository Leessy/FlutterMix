package com.leessy.fluttermix

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.leessy.fluttermix.flutterutil.FlutterBootManager

/**
 *
 * @author Created by 刘承.
 */
class App : Application() {
    private val TAG = javaClass.name

    companion object {
        lateinit var app: App
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        FlutterBootManager.init(this)
    }
}