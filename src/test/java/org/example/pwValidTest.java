package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class pwValidTest {

    @Test
    void isNull_checkIfStringIsNull() {
        //Given
        String nullPassword = null;
        String emptyPassword = "";
        String normalPassword = "password";

        //When
        boolean resultNull = pwValid.isNull(nullPassword);
        boolean resultEmpty = pwValid.isNull(emptyPassword);
        boolean resultNormal = pwValid.isNull(normalPassword);

        //Then
        assertEquals(true, resultNull, "null sollte true liefern");
        assertEquals(false, resultEmpty, "leerer String sollte false liefern");
        assertEquals(false, resultNormal, "normaler String sollte false liefern");
    }
}