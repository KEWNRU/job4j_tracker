package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) throws IllegalArgumentException {
        if (password == null) {
            throw new IllegalArgumentException("Обязательное поле для заполнения");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Пароль должен быть от 8 до 32");
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
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ"
                    + " в верхнем регистре");
        }
        if (!lower) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ"
                    + " в нижнем регистре");
        }
        if (!num) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну цифру");
        }
        if (!spec) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один спец. символ"
                    + " (не цифра и не буква)");
        }
        if (!simple) {
            throw new IllegalArgumentException("Пароль не должен содержать подстрок"
                    + "без учета регистра: qwerty, 12345, password, admin, user.");
        }
        return "Хорошо";
    }
}
