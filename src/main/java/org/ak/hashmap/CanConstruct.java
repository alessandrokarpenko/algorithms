package org.ak.hashmap;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    /*
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
     */

    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        String ransomNote = "aa";
        String magazine = "aab";
        boolean b = canConstruct.canConstruct(ransomNote, magazine);
        System.out.println(b);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineCharArray = magazine.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazineCharArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        char[] ransomNoteCharArray = ransomNote.toCharArray();

        for (char c : ransomNoteCharArray) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else
                return false;
        }

        return true;

    }
}
