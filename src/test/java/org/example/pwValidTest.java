package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

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

    @Test
    void containsSpecialChar() {
        //Given
        String password = "password12?";
        String allowed = "!@#$%^&*()-_+=?.,;:";
        boolean expected = true;
        //When
        boolean actual = pwValid.containsSpecialChar(password, allowed);
        //Then
        assertEquals(expected, actual);
    }
    @Test
    void containsSpecialChar_noSpecialCharInPassword() {
        //Given
        String password = "password123";
        String allowed = "!@#$%^&*()-_+=?.,;:";
        boolean expected = false;
        //When
        boolean actual = pwValid.containsSpecialChar(password, allowed);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void containsSpecialChar_multipleSpecialCharsInPassword() {
        //Given
        String password = "Pa$$word!";
        String allowed = "!@#$%^&*()-_+=?.,;:";
        boolean expected = true;
        //When
        boolean actual = pwValid.containsSpecialChar(password, allowed);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void hasMinGroups() {
        //Given
        String password = "PassworD123";
        int minUpper = 2;
        int minLower = 2;
        boolean expected = true;
        //When
        boolean actual = pwValid.hasMinGroups(password, minUpper, minLower);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void hasMinGroups_notEnoughUpper() {
        //Given
        String password = "password123";
        int minUpper = 2;
        int minLower = 2;
        boolean expected = false;
        //When
        boolean actual = pwValid.hasMinGroups(password, minUpper, minLower);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void hasMinGroups_notEnoughLower() {
        //Given
        String password = "PASSWORD123";
        int minUpper = 2;
        int minLower = 2;
        boolean expected = false;
        //When
        boolean actual = pwValid.hasMinGroups(password, minUpper, minLower);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword() {
        //Given
        String password = "password";
        String[] commonPws = {"123456", "password", "123456789", "12345678", "qwerty", "abc123", "111111", "123123", "admin", "letmein"};
        boolean expected = Arrays.asList(commonPws).contains(password);
        //When
        boolean actual = pwValid.isCommonPassword(password);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_notInList_returnsFalse() {
        //Given
        String password = "securePassword123!";
        String[] commonPws = {"123456", "password", "123456789", "12345678",
                "qwerty", "abc123", "111111", "123123", "admin", "letmein"};
        boolean expected = Arrays.asList(commonPws).contains(password);
        //When
        boolean actual = pwValid.isCommonPassword(password);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_inList_returnsTrue() {
        //Given
        String password = "12345678";
        String[] commonPws = {"123456", "password", "123456789", "12345678",
                "qwerty", "abc123", "111111", "123123", "admin", "letmein"};
        boolean expected = Arrays.asList(commonPws).contains(password);
        //When
        boolean actual = pwValid.isCommonPassword(password);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void isValid() {
        //Given
        String password = "PassworD123?";
        boolean expected  = true;
        //When
        boolean actual = pwValid.isValid(password);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void isValid_missingDigit_returnsFalse() {
        //Given
        String password = "Password!"; // enthält kein Zahlenzeichen
        boolean expected = false;

        //When
        boolean actual = pwValid.isValid(password);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    void isValid_missingSpecialChar_returnsFalse() {
        //Given
        String password = "Password12"; // enthält kein Sonderzeichen
        boolean expected = false;

        //When
        boolean actual = pwValid.isValid(password);

        //Then
        assertEquals(expected, actual);
    }

}