package org.loofer.bean;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/3/30 16:48.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class News {


    /**
     * ctime : 2017-03-09
     * description : 我要WhatYouNeed
     * picUrl : http://mmbiz.qpic.cn/mmbiz_png/zynprs47B4RomkwhjRVJvB6sB6icrgB84zI4MhN7z4K6icr2wMIvrboRpECA7jdvv5WFJC9uPic88zaLUGqzIZ8BQ/0?wx_fmt=png
     * title : 关了灯真的一个样吗？
     * url : http://mp.weixin.qq.com/s/oGQSJlt3foTkcVzBduKxIw
     */

    private String ctime;
    private String description;
    private String picUrl;
    private String title;
    private String url;

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCtime() {
        return ctime;
    }

    public String getDescription() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
