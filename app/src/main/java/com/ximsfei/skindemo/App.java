package com.ximsfei.skindemo;

import android.app.Application;

import com.ximsfei.skindemo.utils.SPUtils;

import skin.support.SkinCompatManager;
import skin.support.design.SkinMaterialManager;

/**
 * Created by ximsfei on 17-1-8.
 */

public class App extends Application {
    private static App sInstance;

    public static App getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        SkinMaterialManager.init(this);
        SkinCompatManager.init(this).loadSkin();
        SPUtils.init(this);
    }
}
