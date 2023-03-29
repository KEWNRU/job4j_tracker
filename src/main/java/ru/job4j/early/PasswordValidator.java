package ru.job4j.early;

import java.util.Calendar;
import java.util.Locale;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        String[] simples = new String[]{"qwerty", "12345", "password", "admin", "user"};
        char[] pass = password.toCharArray();
        boolean upper = false;
        boolean lower = false;
        boolean num = false;
        boolean spec = false;
        boolean simple = true;
        for (char c : pass) {
            if (Character.isLowerCase(c)) {
                lower = true;
            }
            if (Character.isUpperCase(c)) {
                upper = true;
            }
            if (Character.isDigit(c)) {
                num = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                spec = true;
            }
            if (lower && upper && num && spec) {
                break;
            }
        }
        for (String s : simples) {
            String lowerPass = password.toLowerCase();
            if (lowerPass.contains(s)) {
                simple = false;
                break;
            }
        }
        if (!upper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!num) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!spec) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (!simple) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}