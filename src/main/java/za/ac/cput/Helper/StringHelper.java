package za.ac.cput.Helper;
/*
* Helper class
* Name: Raeece Samuels
* */


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringHelper {

    public static boolean isEmptyorNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if (isEmptyorNull(str))
            return StringUtils.EMPTY;
        return str;
    }
    public static void checkStringParam(String paramName, String paramValue){
        if (isEmptyorNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param %s",paramName));
    }
    public static void checkEmail(String email){
        if(!Pattern.matches("^(.+)@(.+)$",email))
            throw new IllegalArgumentException("Some details missing or invalid email(add '@' into your email)");
    }

    public static void checkPhoneNumber(String number){
        if(!Pattern.matches("^\\d{10}$",number))
            throw new IllegalArgumentException("Number must be 10 digits");
    }
}
