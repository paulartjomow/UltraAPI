package com.prixix.ultraapi.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.NavigableMap;
import java.util.TreeMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MathUtil {

    private final static NavigableMap<Integer, String> romanNumbers = new TreeMap<>();

    static {
        romanNumbers.put(1000, "M");
        romanNumbers.put(900, "CM");
        romanNumbers.put(500, "D");
        romanNumbers.put(400, "CD");
        romanNumbers.put(100, "C");
        romanNumbers.put(90, "XC");
        romanNumbers.put(50, "L");
        romanNumbers.put(40, "XL");
        romanNumbers.put(10, "X");
        romanNumbers.put(9, "IX");
        romanNumbers.put(5, "V");
        romanNumbers.put(4, "IV");
        romanNumbers.put(1, "I");
    }

    /**
     * Converts an integer to roman format
     * @param num
     * @return
     */
    public static String toRoman(int num) {
        if (num == 0)
            return "0";

        int literal = romanNumbers.floorKey(num);

        if (num == literal)
            return romanNumbers.get(num);

        return romanNumbers.get(literal) + toRoman(num - literal);
    }

}
