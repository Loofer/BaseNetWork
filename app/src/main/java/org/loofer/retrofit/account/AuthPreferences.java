package org.loofer.retrofit.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 11:37.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class AuthPreferences {


    private static final String KEY_USER = "user";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_USER_DATA = "user_data";

    private SharedPreferences preferences;

    public AuthPreferences(Context context) {
        preferences = context.getSharedPreferences("auth", Context.MODE_PRIVATE);
    }

    public void setUser(String user) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_USER, user);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    public void setToken(String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_TOKEN, token);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    public void setUserData(String userData) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_USER_DATA, userData);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    public String getUser() {
        return preferences.getString(KEY_USER, null);
    }

    public String getToken() {
        return preferences.getString(KEY_TOKEN, null);
    }

    public String getUserData() {
        return preferences.getString(KEY_USER_DATA, null);
    }

    public void clear() {
        SharedPreferences.Editor editor = preferences.edit().clear();
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    public boolean isLogin() {
        return getUser() != null && getToken() != null;
    }

}
