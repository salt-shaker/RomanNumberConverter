package com.romannumberconverter;

import java.util.TreeMap;

public class NumberConverter {

    private TreeMap<Integer, String> map;

    public NumberConverter() {
        map = new TreeMap<Integer, String>();

        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");
    }

    public String toRoman(int i) {
        // URL: https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
        // I borrowed this code from StackOverflow because it is awesome. I did take the time to review it to make sure i understood what it does.
        // First we make a tree map key->value pair hash map. Then add the key->value pairs.
        // The toRoman method uses the floorKey method to determine an equal or less matching value
        // If an exact match is not found, it calls toRoman() recursively till an exact match is found for the smallest number
        // once an exact match is found, that string is returned from the toRoman() method.
        int l = map.floorKey(i);
        if (i == l) {
            return map.get(i);
        }
        return map.get(l) + toRoman(i - l);
    }

    public int toNumber(String s) {
        // URL: https://stackoverflow.com/questions/20313254/roman-numeral-to-number-conversion
        // Also borrowed code for decoding
        // It loops though each character in the string except the last one
        // sending each CHAR to decode to determine what value the letter represents
        // It compares the current value with the next value to determine if it should subtract or add from the current total
        // Then the toNumber() method returns the total and an INT
            int result = 0;


            String uRoman = s.toUpperCase(); //case-insensitive
            for (int i = 0; i < uRoman.length() - 1; i++) {//loop over all but the last character
                if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i + 1))) {
                    result -= decodeSingle(uRoman.charAt(i));
                } else {
                    result += decodeSingle(uRoman.charAt(i));
                }
            }
            result += decodeSingle(uRoman.charAt(uRoman.length() - 1));

            return result;
    }

    private int decodeSingle(char letter) {
        switch (letter) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}
