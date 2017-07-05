package com.nightmode;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaowu on 2017/6/13.
 */

public class BaseApplication extends Application {
    private static BaseApplication application;

    private SharedPreferences sp;

    // 是否是夜间模式
    private boolean isNight = true;

    // map存值，key=日间模式的图， value=夜间模式的图
    private Map<Integer, Integer> map;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        sp = getSharedPreferences("config", MODE_PRIVATE);
        isNight = sp.getBoolean("is_night", false);
    }

    /**
     * 类似单例模式，返回的是当前Application的对象
     * @return
     */
    public static BaseApplication getInstance() {
        return application;
    }

    public boolean isNight() {
        return isNight;
    }

    /**
     * 初始化颜色和图片的集合
     */
    private void initImages() {
        map = new HashMap<>();
        map.put(R.mipmap.default_user_leftdrawer, R.mipmap.default_user_leftdrawer_night);
        map.put(Color.BLACK, Color.WHITE);
    }

    /**
     * 日夜间模式分别得到不同的资源文件
     * @param resId
     * @return
     */
    public int getResId(int resId) {
        if (map == null) {
            initImages();
        }
        // 夜间模式，显示value的资源
        if (isNight) {
            return map.get(resId);
        } else { // 日间模式，显示key的资源
            return resId;
        }
    }

    public void setNight(boolean night) {
        isNight = night;
        // 设置夜间模式的时候保存到本地
        sp.edit().putBoolean("is_night", night).commit();
    }
}
