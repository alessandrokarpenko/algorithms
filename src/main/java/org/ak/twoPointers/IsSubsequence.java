package org.ak.twoPointers;

public class IsSubsequence {

    /*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
     */

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();

        String s = "abc";
        String t = "ahbgdc";


        boolean subsequence = isSubsequence.isSubsequence(s, t);
        System.out.println(subsequence);
    }

    public boolean isSubsequence(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int pointerS = 0;
        int pointerT = 0;

        while (pointerT < tArray.length && pointerS < sArray.length) {

            if (tArray[pointerT] == sArray[pointerS]) {
                pointerT++;
                pointerS++;
            } else {
                pointerT++;
            }
        }

        return pointerS == sArray.length;

    }
}
