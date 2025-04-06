package edu.holan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
    @author joert
    @project lab4
    @since 06.04.2025 - 22.55
*/

class RomanToArabicConverterTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void whenInputIsThenReturns1() {
        // Test the simplest case with a single numeral
        assertEquals(1, RomanToArabicConverter.romanToArabic("I"));
    }

    @Test
    public void whenInputIsIIIThenReturns3() {
        // Test additive property with repeated numerals
        assertEquals(3, RomanToArabicConverter.romanToArabic("III"));
    }

    @Test
    public void whenInputIsIVThenReturns4() {
        // Test the subtraction principle with I before V
        assertEquals(4, RomanToArabicConverter.romanToArabic("IV"));
    }

    @Test
    public void whenInputIsIXThenReturns9() {
        // Test the subtraction principle with I before X
        assertEquals(9, RomanToArabicConverter.romanToArabic("IX"));
    }

    @Test
    public void whenInputIsXLThenReturns40() {
        // Test the subtraction principle with X before L
        assertEquals(40, RomanToArabicConverter.romanToArabic("XL"));
    }

    @Test
    public void whenInputIsXCThenReturns90() {
        // Test the subtraction principle with X before C
        assertEquals(90, RomanToArabicConverter.romanToArabic("XC"));
    }

    @Test
    public void whenInputIsCDThenReturns400() {
        // Test the subtraction principle with C before D
        assertEquals(400, RomanToArabicConverter.romanToArabic("CD"));
    }

    @Test
    public void whenInputIsCMThenReturns900() {
        // Test the subtraction principle with C before M
        assertEquals(900, RomanToArabicConverter.romanToArabic("CM"));
    }

    @Test
    public void whenInputIsMCMXCIVThenReturns1994() {
        // Test a complex case with multiple subtraction principles
        // M = 1000, CM = 900, XC = 90, IV = 4 => 1994
        assertEquals(1994, RomanToArabicConverter.romanToArabic("MCMXCIV"));
    }

    @Test
    public void whenInputIsMMCDXXIVThenReturns2424() {
        // Test another complex case with a mix of addition and subtraction
        // MM = 2000, CD = 400, XX = 20, IV = 4 => 2424
        assertEquals(2424, RomanToArabicConverter.romanToArabic("MMCDXXIV"));
    }
}