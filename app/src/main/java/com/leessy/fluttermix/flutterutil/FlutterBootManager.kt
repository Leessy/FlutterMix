package com.leessy.fluttermix.flutterutil

import android.app.Application
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.Platform
import com.idlefish.flutterboost.Utils
import com.idlefish.flutterboost.interfaces.INativeRouter
import io.flutter.embedding.android.FlutterView

object FlutterBootManager {
    fun init(app: Application) {
        /**
         * 不仅打开Native页面会执行，在Flutter页面打开Flutter  widget也会执行该方法
         **/
        val router = INativeRouter { context, url, urlParams, requestCode, exts ->
            val assembleUrl: String = Utils.assembleUrl(url, urlParams)
            PageRouter.openPageByUrl(context, assembleUrl, urlParams)
        }
        val boostLifecycleListener: FlutterBoost.BoostLifecycleListener =
            object : FlutterBoost.BoostLifecycleListener {
                override fun beforeCreateEngine() {}
                override fun onEngineCreated() {}
                override fun onPluginsRegistered() {}
                override fun onEngineDestroy() {}
            }
        val platform: Platform = FlutterBoost.ConfigBuilder(app, router)
            .isDebug(true)
            .whenEngineStart(FlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED)
            .renderMode(FlutterView.RenderMode.texture)
            .lifecycleListener(boostLifecycleListener)
            .build()
        FlutterBoost.instance().init(platform)

//        /**
//         * 不仅打开Native页面会执行，在Flutter页面打开Flutter  widget也会执行该方法
//         **/
//        val router = INativeRouter { context, url, urlParams, requestCode, exts ->
//            val assembleUrl = Utils.assembleUrl(url, urlParams)
////            Timber.e("native open :${url} ${urlParams}")
////            NativePageRouter.openPageByUrl(context, assembleUrl, requestCode)
//        }
//
//        val pluginsRegister = object : FlutterBoost.BoostPluginsRegister {
//
//            override fun registerPlugins(mRegistry: PluginRegistry?) {
//                GeneratedPluginRegistrant.registerWith(mRegistry)
//                TextPlatformViewPlugin.register(mRegistry?.registrarFor("TextPlatformViewPlugin"))
//            }
//        }
//
//        val platform = FlutterBoost.ConfigBuilder(app, router)
//                .isDebug(BuildConfig.DEBUG)
//                .whenEngineStart(FlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED)
//                .renderMode(FlutterView.RenderMode.texture)
//                .pluginsRegister(pluginsRegister)
//                .build()
//
//        FlutterBoost.instance().init(platform)
    }
}
