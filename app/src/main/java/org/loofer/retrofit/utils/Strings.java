package org.loofer.retrofit.utils;

import android.text.TextUtils;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 11:33.
 * 描述：字符串工具类
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public final class Strings {


    private Strings() {
        // No instances.
    }

    public static boolean isBlank(CharSequence string) {
        return TextUtils.isEmpty(string);
    }

    public static boolean isNotBlank(CharSequence string) {
        return !isBlank(string);
    }

}
