package com.codurance.training.tasks;

public class StringUtils {

    public static boolean isNumber(String number) {
        int n = 0;
        try {
            n = Integer.parseInt(number);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
