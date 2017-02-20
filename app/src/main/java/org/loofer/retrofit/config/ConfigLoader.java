package org.loofer.retrofit.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import org.loofer.retrofit.utils.FileUtil;

public class ConfigLoader {

    private static Config config;

    private final static String CONFIG_NAME = "config.json";

    public static boolean checkSucess(Context context, int code) {
        loadConfig(context);
        Log.v("ConfigLoader", "web :" + code + ">>>>>>>>>>>>isOk：" + config.getSucessCode().contains(String.valueOf(code)));
        return config.getSucessCode().contains(String.valueOf(code));
    }

    public static Config loadConfig(Context context) {

        if (config != null) {
            return config;
        }
        String jsonStr = FileUtil.loadFromAssets(context, CONFIG_NAME);
        if (jsonStr == null) {
            return null;
        }
        return config = new Gson().fromJson(jsonStr, Config.class);
    }

    public static boolean isFormat(Context context) {
        loadConfig(context);
        return TextUtils.equals(config.getIsFormat(), "ture");
    }

}
