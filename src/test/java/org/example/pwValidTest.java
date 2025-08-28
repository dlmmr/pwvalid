package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class pwValidTest {

    @Test
    void isNull_checkIfStringIsNull() {
        //Given
        String password = null;
        //When
        boolean resultNull = pwValid.isNull(password);
        //Then
        assertEquals(true, resultNull); //null sollte true liefern

    }

    @Test
    void isNull_checkIfStringIsEmpty() {
        //Given
        String password = "";
        //When
        boolean resultEmpty = pwValid.isNull(password);
        //Then
        assertEquals(false, resultEmpty); //leerer String sollte false liefern

    }

    @Test
    void isNull_checkIfStringIsValid() {
        //Given
        String password = "password";
        //When
        boolean resultNormal = pwValid.isNull(password);
        //Then
        assertEquals(false, resultNormal); //normaler String sollte false liefern
    }

    @Test
    void isBlank_checkIfStringIsBlank() {
        //Given
        String password = "";
        boolean expected =true;
        //When
        boolean actual = pwValid.isBlank(password);
        //Then
        assertEquals(expected, actual); //leerer String sollte false liefern
    }

    @Test
    void hasMinLength() {
        //Given
        String password = "password";
        int min = 8;
        boolean expected = true;
        //When
        boolean actual = pwValid.hasMinLength(password, min);
        //Then
        assertEquals(expected, actual);

    }
}