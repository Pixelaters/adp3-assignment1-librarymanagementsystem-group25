package za.ac.cput.Helper;
/*
* Helper class
* Name: Raeece Samuels
* */


import org.apache.commons.lang3.StringUtils;

public class StringHelper {
    public static boolean isEmptyorNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if (isEmptyorNull(str))
            return StringUtils.EMPTY;
        return str;
    }
    public static void setStringParam(String paramName, String paramValue){
        if (isEmptyorNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param %s",paramName));
    }
}
