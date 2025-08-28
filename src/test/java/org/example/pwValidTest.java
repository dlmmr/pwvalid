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

    @Test
    void containsDigit() {
        //Given
        String password = "password123";
        boolean expected = true;
        //When
        boolean actual = pwValid.containsDigit(password);
        //Then
        assertEquals(expected, actual);
    }
    @Test
    void containsDigit_noDigits() {
        //Given
        String password = "password";
        boolean expected = false;

        //When
        boolean actual = pwValid.containsDigit(password);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_oneDigit() {
        //Given
        String password = "passw0rd";
        boolean expected = true;

        //When
        boolean actual = pwValid.containsDigit(password);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_simpleCheckIfStringContainsUpperAndLower() {
        //Given
        String password = "Password";
        boolean expected = true;
        //When
        boolean actual = pwValid.containsUpperAndLower(password);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_onlyUppercase() {
        //Given
        String password = "PASSWORD";
        boolean expected = false;

        //When
        boolean actual = pwValid.containsUpperAndLower(password);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_onlyLowercase() {
        //Given
        String password = "password";
        boolean expected = false;

        //When
        boolean actual = pwValid.containsUpperAndLower(password);

        //Then
        assertEquals(expected, actual);
    }

}