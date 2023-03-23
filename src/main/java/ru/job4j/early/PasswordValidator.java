package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) throws IllegalArgumentException {
        if (password == null) {
            throw new IllegalArgumentException("������������ ���� ��� ����������");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("������ ������ ���� �� 8 �� 32");
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
            throw new IllegalArgumentException("������ ������ ��������� ���� �� ���� ������"
                    + " � ������� ��������");
        }
        if (!lower) {
            throw new IllegalArgumentException("������ ������ ��������� ���� �� ���� ������"
                    + " � ������ ��������");
        }
        if (!num) {
            throw new IllegalArgumentException("������ ������ ��������� ���� �� ���� �����");
        }
        if (!spec) {
            throw new IllegalArgumentException("������ ������ ��������� ���� �� ���� ����. ������"
                    + " (�� ����� � �� �����)");
        }
        if (!simple) {
            throw new IllegalArgumentException("������ �� ������ ��������� ��������"
                    + "��� ����� ��������: qwerty, 12345, password, admin, user.");
        }
        return "������";
    }
}
