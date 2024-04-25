package com.example.rqchallenge;

/**
 * This class is used to get all the static values which will avoid redundant code
 * @author Varun Kulkarni
 */
public class Static {

    public static final String EMAIL_REGEX = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@" +
            "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
}
