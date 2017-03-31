package org.loofer.retrofit.exception;

public enum EnumStatus {
    UNAUTHORIZED("401", "连接失败"),
    SUCCESS("200", "请求成功"),
    FORBIDDEN("403", "禁止访问"),
    NOT_FOUND("404", "服务器地址未找到"),
    REQUEST_TIMEOUT("408", "请求超时"),
    INTERNAL_SERVER_ERROR("500", "服务器出错"),
    BAD_GATEWAY("502", "无效的请求"),
    SERVICE_UNAVAILABLE("503", "服务器不可用"),
    GATEWAY_TIMEOUT("504", "网关响应超时"),
    ACCESS_DENIED("302", "网络错误"),
    HANDEL_ERRROR("417", "接口处理失败"),
    DEFAULT_ERROR("602", "自定义错误"),
    NO_DATA("524", "服务器未返回数据"),
    FORCE_LOGOUT("600", "服务器未返回数据"),
    NO_NET("700", "服务器未返回数据"),

    /**
     * 和服务器约定的异常
     */

    UNKNOWN("1000", "未知错误"),
    PARSE_ERROR("1001", "解析错误"),
    NETWORD_ERROR("1002", "网络错误"),
    HTTP_ERROR("1003", "协议出错"),
    SSL_ERROR("1005", "证书出错"),
    TIMEOUT_ERROR("1006", "连接超时"),
    SSL_NOT_FOUND("1007", "证书未找到"),
    NULL("-100", "出现空值"),
    FORMAT_ERROR("1008", "格式错误");

    public String code;
    public String desc;

    EnumStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

//    public static String getString(int resId) {
//        return MyApplication.getInstance().getString(resId);
//    }

    public static EnumStatus getEnumStatus(String code) {
        for (EnumStatus status : EnumStatus.values()) {
            if (code != null && code.equals(status.code)) {
                return status;
            }
        }
        return NO_DATA;
    }
}
