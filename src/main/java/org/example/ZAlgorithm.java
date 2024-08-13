package org.example;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {

    // Function to search for the pattern in the text using the Z-algorithm
    public static List<Integer> search(String text, String pattern) {
        // Concatenate pattern, special character, and text
        String concat = pattern + "$" + text;
        int l = concat.length();

        // Create Z array
        int[] Z = new int[l];
        calculateZ(concat, Z);

        List<Integer> result = new ArrayList<>();

        // Now, check where the pattern occurs in the text
        for (int i = 0; i < l; i++) {
            // If Z[i] is equal to pattern length, it means pattern is found at index i
            if (Z[i] == pattern.length()) {
                result.add(i - pattern.length() - 1 + 1); // 1-based index
            }
        }

        return result;
    }

    // Function to calculate Z array
    private static void calculateZ(String str, int[] Z) {
        int n = str.length();
        int L = 0, R = 0, K;

        for (int i = 1; i < n; i++) {
            // Case 1: i > R
            if (i > R) {
                L = R = i;
                while (R < n && str.charAt(R) == str.charAt(R - L)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                // Case 2: i <= R
                K = i - L;
                if (Z[K] < R - i + 1) {
                    Z[i] = Z[K];
                } else {
                    L = i;
                    while (R < n && str.charAt(R) == str.charAt(R - L)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }

    // Main function to test the search function
    public static void main(String[] args) {
        String text1 = "batmanandrobinarebat";
        String pattern1 = "bat";
        System.out.println("Occurrences of 'bat' in text: " + search(text1, pattern1));

        String text2 = "abesdu";
        String pattern2 = "edu";
        System.out.println("Occurrences of 'edu' in text: " + search(text2, pattern2));
    }
}

