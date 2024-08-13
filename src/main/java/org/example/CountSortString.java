package org.example;

public class CountSortString {

    // Function to sort the string using counting sort
    public static String countSort(String arr) {
        int n = arr.length();

        // Create a count array to store count of each character
        int[] count = new int[26]; // Since there are 26 lowercase English letters

        // Store the count of each character in the count array
        for (int i = 0; i < n; i++) {
            count[arr.charAt(i) - 'a']++;
        }

        // Create a character array to store the sorted characters
        char[] sortedArray = new char[n];
        int index = 0;

        // Build the sorted string using the count array
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                sortedArray[index++] = (char) (i + 'a');
                count[i]--;
            }
        }

        // Convert the character array back to a string
        return new String(sortedArray);
    }

    // Main function to test the countSort
    public static void main(String[] args) {
        String s1 = "edsab";
        String s2 = "geeksforgeeks";

        System.out.println("Sorted string for 'edsab': " + countSort(s1));
        System.out.println("Sorted string for 'geeksforgeeks': " + countSort(s2));
    }
}

