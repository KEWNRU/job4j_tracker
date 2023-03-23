package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void whenValidPass() {
        String password = "We2!Ker#dkK";
        PasswordValidator.validate(password);
        assertThat(PasswordValidator.validate(password)).isEqualTo("������");
    }

    @Test
    public void whenPassWithoutUpper() {
        String password = "dfjwej2!wefh#";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(password);
                });
        assertThat(exception.getMessage()).isEqualTo("������ ������ ��������� ���� �� ���� ������ "
                + "� ������� ��������");
    }

    @Test
    public void whenPassWithoutLower() {
        String password = "FKJNDKN!2";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(password);
                });
        assertThat(exception.getMessage()).isEqualTo("������ ������ ��������� ���� �� ���� ������ "
                + "� ������ ��������");
    }

    @Test
    public void whenPassWithoutDigit() {
        String password = "ggbdDDf!G";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(password);
                });
        assertThat(exception.getMessage()).isEqualTo("������ ������ ��������� ���� �� ���� �����");
    }

    @Test
    public void whenPassWithoutSpec() {
        String password = "ASdrvb32gh";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(password);
                });
        assertThat(exception.getMessage()).isEqualTo("������ ������ ��������� ���� ��"
                + " ���� ����. ������ (�� ����� � �� �����)");
    }

    @Test
    public void whenPassWithSimple() {
        String password = "qwerTy#02";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(password);
                });
        assertThat(exception.getMessage()).isEqualTo("������ �� ������ ��������� ��������"
                + "��� ����� ��������: qwerty, 12345, password, admin, user.");
    }

    @Test
    public void whenPassIsShort() {
        String password = "iF1!";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(password);
                });
        assertThat(exception.getMessage()).isEqualTo("����� ������ ������ ���������"
                + " � ��������� �� 8 �� 32");
    }

    @Test
    public void whenPassIsNull() {
        String password = null;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(password);
                });
        assertThat(exception.getMessage()).isEqualTo("������������ ���� ��� ����������");
    }
}