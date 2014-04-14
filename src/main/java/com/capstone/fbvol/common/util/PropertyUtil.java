package com.capstone.fbvol.common.util;

import java.util.ResourceBundle;

/**
 * 설정파일을 읽어 설정값을 가져온다.
 *
 * @author 명준민
 * @date   2007. 05. 31
 * @desc   Class에 대한 설명을 기입하세요.
 */
public class PropertyUtil {

    //classpath 내의 kipo.properties 로드
    private static ResourceBundle messageBundle;

    static {
        //기동시 한번만 읽어오도록 한다.
        if(messageBundle==null) {
            messageBundle =
                ResourceBundle.getBundle("config/fiamm-config",
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
