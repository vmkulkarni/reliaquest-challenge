package com.example.rqchallenge.Utility;

import java.util.regex.Pattern;

/**
 * This is a utility class where we can write methods which are reusable and can be called from anywhere in the project
 * @author Varun Kulkarni
 */
public class Utils {
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
