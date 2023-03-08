package ru.job4j.pojo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void eqName1() {
        License first = new License();
        first.setCode("1337");
        License second = new License();
        second.setCode("1337");
        assertThat(first).isEqualTo(second);
    }
}