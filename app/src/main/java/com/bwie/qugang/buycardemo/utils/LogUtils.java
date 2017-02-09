package com.bwie.qugang.buycardemo.utils;

import android.util.Log;

/**
 * 1.类的用途：Log工具类
 * 2.@author
 * 3.@date
 */
public class LogUtils {
    //定义一个boolean值  如果说程序完事之后 直接该值就可以取消所有的Log
    private static  boolean DEBUG = true;
    //info
    public static void Logi(String tag,String info){
        if(DEBUG){
           Log.i(tag,info);
        }
    }
    //debug
    public static void Logd(String tag,String info){
        if(DEBUG){
            Log.d(tag,info);
        }
    }
    //warn
    public static void Logw(String tag,String info){
        if(DEBUG){
            Log.w(tag,info);
        }
    }
    //error
    public static void Loge(String tag,String info){
        if(DEBUG){
            Log.e(tag,info);
        }
    }
}
