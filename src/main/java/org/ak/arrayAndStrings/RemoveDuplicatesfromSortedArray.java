package org.ak.arrayAndStrings;

import java.util.*;

public class RemoveDuplicatesfromSortedArray {

    /*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.
    Custom Judge:

    The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }
    If all assertions pass, then your solution will be accepted.



    Example 1:

    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    Example 2:

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).


    Constraints:

    1 <= nums.length <= 3 * 104
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
     */

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicatesfromSortedArray.removeDuplicates4(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {

        Map<Integer, Integer> map = new LinkedHashMap<>();

        Integer value = null;
        for (int i = 0; i < nums.length; i++) {
            value = map.get(nums[i]);

            if (value == null) {
                map.put(nums[i], 0);
            } else {
                map.put(nums[i], ++value);
            }
        }

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[index] = entry.getKey();
            index++;
        }

        long emptyValues = map.values().stream().mapToInt(Integer::intValue).sum();

        for (int i = 0; i < emptyValues; i++) {
            nums[nums.length - 1 - i] = Integer.MAX_VALUE;
        }

        return (int) (nums.length - emptyValues);
    }

    public int removeDuplicates2(int[] nums) {

        List<Integer> list = new ArrayList<>();

        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                counter++;
            else
                list.add(nums[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        for (int i = 0; i < counter; i++) {
            nums[nums.length-counter+i] = Integer.MAX_VALUE;
        }

        return nums.length-counter;
    }

    public int removeDuplicates3(int[] nums) {

        int pointer1 = 0;
        int pointer2 = 1;

        int previousValue = nums[pointer1];

        while (pointer2 < nums.length) {

            int currentValue = nums[pointer2];

            if (currentValue==previousValue) {
                previousValue = nums[pointer2];
                nums[pointer1] = Integer.MAX_VALUE;
                pointer1 = pointer2;
                pointer2++;

            } else {
                pointer1 = pointer2;
                previousValue = nums[pointer1];
                pointer2++;
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return (int) Arrays.stream(nums).filter(x->x!=Integer.MAX_VALUE).count();
    }

    //cheating solution from ChatGPT where we move and count elements but do not mark duplicates ad Integer.Max_VALUE as I got from task, but it's not necessary
    public int removeDuplicates4(int[] nums) {

        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
