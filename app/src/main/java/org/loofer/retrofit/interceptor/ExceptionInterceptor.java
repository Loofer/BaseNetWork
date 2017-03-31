package org.loofer.retrofit.interceptor;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.loofer.retrofit.exception.BaseException;
import org.loofer.retrofit.exception.EnumStatus;
import org.loofer.retrofit.exception.ForceLogoutException;
import org.loofer.retrofit.exception.JsonException;
import org.loofer.retrofit.exception.OtherException;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/3/30 20:32.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class ExceptionInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().toString();
        Response response = chain.proceed(request);
        ResponseBody body = response.body();
        try {
            String reultJson = body.string();//body的数据只允许读取一次
            if ( TextUtils.isEmpty(reultJson)) {
                throw new BaseException(EnumStatus.NO_DATA.code, EnumStatus.NO_DATA.desc);
            }

            JSONObject object = new JSONObject(reultJson);
            String code = object.optString("code");
            if (!TextUtils.isEmpty(code)) {
                String trimStatus = code.trim();
//                L.e("请求链接",url,"返回的状态码Status",trimStatus);
                EnumStatus enumStatus = EnumStatus.getEnumStatus(trimStatus);
                switch (enumStatus){
                    case SUCCESS:
                        // TODO: 2017/3/31 加密
                        break;
                    case FORCE_LOGOUT:
                        throw new ForceLogoutException(enumStatus.code,enumStatus.desc);
                    case NO_DATA:
                    case NO_NET:
                    default:
                        throw new OtherException(enumStatus.code,enumStatus.desc);
                }
            }
            MediaType mediaType = response.body().contentType();
            response = response.newBuilder().body(ResponseBody.create(mediaType, reultJson)).build();
            return response;
        } catch (JSONException e) {
            e.printStackTrace();
            throw new JsonException("",e.getMessage());
        }
    }



}
