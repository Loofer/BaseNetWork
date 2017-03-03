package org.loofer.retrofit.subscriber;

import org.loofer.retrofit.BaseSubscriber;
import org.loofer.retrofit.Throwable;

import okhttp3.ResponseBody;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 16:04.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class ApiSubscriber <T> extends BaseSubscriber<ResponseBody> {

    public ApiSubscriber() {
    }

    @Override
    public void onStart() {
        super.onStart();
        // todo some common as show loadding  and check netWork is NetworkAvailable

    }

    @Override
    public void onCompleted() {
        // todo some common as  dismiss loadding

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(ResponseBody responseBody) {
        // TODO: 2017/2/26  error处理
//        try {
//            byte[] bytes = responseBody.bytes();
//            String jsStr = new String(bytes);
//            Log.d("OkHttp", "ResponseBody:" + jsStr);
//            if (callBack != null) {
//                try {
//                    /**
//                     * if need parse baseRespone<T> use ParentType, if parse T use childType . defult parse baseRespone<T>
//                     *
//                     *  callBack.onSuccee((T) JSON.parseArray(jsStr, (Class<Object>) finalNeedType));
//                     *  Type finalNeedType = needChildType;
//                     */
//
//                    HttpResult<T> baseResponse = null;
//
//                    if (new Gson().fromJson(jsStr, finalNeedType) == null) {
//                        throw new NullPointerException();
//                    }
//                    baseResponse = new Gson().fromJson(jsStr, finalNeedType);
//                    if (ConfigLoader.isFormat(mContext) && baseResponse.getData() == null & baseResponse.getResult() == null) {
//                        throw new FormatException();
//                    }
//
//                    if (baseResponse.isOk(mContext)) {
//                        callBack.onSuccee((T) new Gson().fromJson(jsStr, finalNeedType));
//                    } else {
//                        String msg =
//                                baseResponse.getMsg() != null ? baseResponse.getMsg() : baseResponse.getError() != null ? baseResponse.getError() : baseResponse.getMessage() != null ? baseResponse.getMessage() : "api未知异常";
//
//                        ServerException serverException = new ServerException(baseResponse.getCode(), msg);
//                        callBack.onError(ApiException.handleException(serverException));
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    if (callBack != null) {
//                        callBack.onError(ApiException.handleException(new FormatException()));
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (callBack != null) {
//                callBack.onError(ApiException.handleException(e));
//            }
//        }
    }

}
