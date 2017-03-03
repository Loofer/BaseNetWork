package org.loofer.retrofit.transformer;

import com.google.gson.JsonParseException;

import org.loofer.retrofit.HttpResult;

import rx.functions.Func1;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 10:59.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class HandleFuc<T> implements Func1<HttpResult<T>, T> {

    @Override
    public T call(HttpResult<T> response) {
        if (response == null || (response.getData() == null && response.getResult() == null)) {
            throw new JsonParseException("后端数据不对");
        }
            /*if (!response.isOk()) {
                throw new RuntimeException(response.getCode() + "" + response.getMsg() != null ? response.getMsg() : "");
            }
*/
        return response.getData();
    }
}
