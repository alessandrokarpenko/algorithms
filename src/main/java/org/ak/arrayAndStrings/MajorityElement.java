package org.ak.arrayAndStrings;

import java.util.Arrays;
import java.util.Objects;

public class MajorityElement {

    /*

    Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?


     */

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();

        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(majorityElement.majorityElement2(nums));
    }

    public int majorityElement(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {

        Integer target = null;
        int count = 0;

        for (Integer element : nums) {

            if (count == 0)
                target = element;

            if (Objects.equals(target, element)) {
                count++;
            } else {
                count --;
            }
        }

        return target;
    }

}
