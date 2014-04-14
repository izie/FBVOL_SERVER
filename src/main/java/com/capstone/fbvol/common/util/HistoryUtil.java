package com.capstone.fbvol.common.util;

import java.util.ResourceBundle;

/**
 * applicationContext.xml내의 propertyConfigurer bean 에서 설정한
 * classpath 내의 ibb-history.properties 로드
 *
 */
public class HistoryUtil {

    private static ResourceBundle messageBundle;

    /** 기동시 한번만 읽어오도록 한다. */
    static {
        if(messageBundle==null) {
            messageBundle =
                ResourceBundle.getBundle("ibb-history",
                        java.util.Locale.KOREA);
        }
    }

    public static String get(String key) {
        try {
            String returnString = "";
            returnString = messageBundle.getString(key);

            return returnString;
        } catch (Exception ex) {
            return null;
        }
    }
}
