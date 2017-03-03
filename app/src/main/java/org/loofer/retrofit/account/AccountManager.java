package org.loofer.retrofit.account;

import android.content.Context;
import android.text.TextUtils;

import org.loofer.app.App;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 11:36.
 * 描述：账户管理，请求统一添加token
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public enum AccountManager {


    INSTANCE;

    private final AuthPreferences authPreferences;
    private Account mCurrentAccount;
    private Context mContext;

    AccountManager() {
        mContext = App.appContext();
        authPreferences = new AuthPreferences(mContext);
    }

    public boolean isLogin() {
        return authPreferences.isLogin();
    }

    public void logout() {
        mCurrentAccount = null;
        authPreferences.clear();
    }

    public void storeAccount(Account account) {
        mCurrentAccount = account;
        authPreferences.setToken(account.token());
        authPreferences.setUser(account.name());
        authPreferences.setUserData(account.toJson());
    }

    public String token() {
        return authPreferences.getToken();
    }

    public String user() {
        return authPreferences.getUser();
    }

    @SuppressWarnings("unchecked") public <T extends Account> T getCurrentAccount() {
        if (mCurrentAccount == null) {
            String accountJson = authPreferences.getUserData();
            if (!TextUtils.isEmpty(accountJson) && mContext instanceof AccountProvider) {
                mCurrentAccount = ((AccountProvider) mContext).provideAccount(accountJson);
            }
        }
        return (T) mCurrentAccount;
    }

}
