package org.loofer.retrofit.download;

/**
 * ============================================================
 * 版权：  xx 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/20 18:18.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */
public abstract class DownLoadCallBack {

    public void onStart(String key){}

    public void onCancel(){}

    public void onCompleted(){}


    /** Note : the Fun run not MainThred
     * @param e
     */
    abstract public void onError(Throwable e);

    public void onProgress(String key, long fileSizeDownloaded, long  totalSize ){}

    /**  Note : the Fun run UIThred
     * @param path
     * @param name
     * @param fileSize
     */
    abstract public void onSucess(String key, String path, String name, long fileSize);

}
