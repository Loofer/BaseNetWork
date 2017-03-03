package org.loofer.retrofit.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public final class AndroidUtilities {

  /**
   * 获取AndroidManifest中配置的meta-data
   * @param context Context
   * @param key String
   * @return String
   */
  public static String getMetaData(Context context, String key) {
    Bundle metaData = null;
    String value = null;
    if (context == null || key == null) {
      return null;
    }
    try {
      ApplicationInfo ai = context.getPackageManager().getApplicationInfo(
          context.getPackageName(), PackageManager.GET_META_DATA);
      if (null != ai) {
        metaData = ai.metaData;
      }
      if (null != metaData) {
        value = metaData.getString(key);
      }
    } catch (PackageManager.NameNotFoundException e) {
      // Nothing to do
    }
    return value;
  }

}
