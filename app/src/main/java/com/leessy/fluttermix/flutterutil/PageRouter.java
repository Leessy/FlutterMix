package com.leessy.fluttermix.flutterutil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.leessy.fluttermix.NativeActivity;

import java.util.HashMap;
import java.util.Map;

public class PageRouter {

    public final static Map<String, String> pageName = new HashMap<String, String>() {{
        put("first", FLUTTERWIDGET_FIRSTPAGE);
        put("second", FLUTTER_SECONDPAGE);
        put("tab", "tab");
        put("sample://flutterPage", "flutterPage");
        put("", "flutterPage");
    }};

    //需要相互启动的页面，在此注册即可
    public static final String FLUTTERWIDGET_FIRSTPAGE = "flutterbus://flutter_FirstPage";
    public static final String FLUTTER_SECONDPAGE = "flutterbus://flutter_SecondPage";

    public static final String NATIVE_PAGE_URL = "flutterbus://flutternativePage";
    public static final String FLUTTER_FRAGMENT_PAGE_URL = "flutterbus://flutterFragmentPage";

    public static boolean openPageByUrl(Context context, String url, Map params) {
        return openPageByUrl(context, url, params, 0);
    }

    public static boolean openPageByUrl(Context context, String url, Map params, int requestCode) {
        String path = url.split("\\?")[0];
        Log.i("openPageByUrl", path+"  context:"+context);
        try {
            if (pageName.containsKey(path)) {
                Intent intent = BoostFlutterActivity.withNewEngine().url(pageName.get(path)).params(params)
                        .backgroundMode(BoostFlutterActivity.BackgroundMode.opaque).build(context);
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    activity.startActivityForResult(intent, requestCode);
                } else {
                    context.startActivity(intent);
                }
                Log.i("openPageByUrl", path+"   intent:"+intent);
                return true;
            } else if (url.startsWith(FLUTTER_FRAGMENT_PAGE_URL)) {
//                context.startActivity(new Intent(context, FlutterFragmentPageActivity.class));

                return true;
            } else if (url.startsWith(NATIVE_PAGE_URL)) {
                //flutter启动一个native 页
                context.startActivity(new Intent(context, NativeActivity.class));
                return true;
            }
            return false;

        } catch (Throwable t) {
            return false;
        }
    }
}