package com.nightmode;

/**
 * Created by xiaowu on 2017/6/12.
 */

public class Demo {
    private boolean hasImg;
    private String name;
    private int resId;

    public Demo() {
    }

    public Demo(boolean hasImg, String name) {
        this.hasImg = hasImg;
        this.name = name;
    }

    public Demo(boolean hasImg, String name, int resId) {
        this.hasImg = hasImg;
        this.name = name;
        this.resId = resId;
    }

    public boolean isHasImg() {
        return hasImg;
    }

    public void setHasImg(boolean hasImg) {
        this.hasImg = hasImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
