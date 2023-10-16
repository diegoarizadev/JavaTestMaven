package org.n0rf3n.Utils;

public class StringUtil {

    public static String repeat(String str, int times) {


        if(times < 0){
            throw new IllegalArgumentException("Negative times not allowed");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++) {
            result.append(str);
        }

        return result.toString();
    }


    public static boolean isEmpty(String str) {

        if( str == null || str.length() <= 0 ){
            throw new IllegalArgumentException(" str is null or empty ");
        }

        if(str.isEmpty()){
            return true;
        }else if (str.contains(" ")) {
            return true;
        }else{
            return false;
        }

    }


}
