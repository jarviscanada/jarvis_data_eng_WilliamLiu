package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

  /**
   * Big-O: O(n^2)
   * Justification: for every element, look through the rest of the list
   */
  public int[] twoSumBrute(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (target - nums[j] == nums[i]) {
          return new int[]{i, j};
        }
      }
    }
    return new int[2];
  }

  /**
   * Big-O: O(nlog(n))
   * Justification: sort (nlog(n)); for every element, do binary search (log(n))
   */
  public int[] twoSumSort(int[] nums, int target) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int remaining = target - nums[i];
      int foundIndex = Arrays.binarySearch(nums, i + 1, nums.length, remaining);
      if (foundIndex > 0) {
        return new int[]{i, foundIndex};
      }
    }
    return new int[2];
  }

  /**
   * Big-O: O(n) time, O(n) space
   * Justification: traverse list once, remembering seen elements
   */
  public int[] twoSumMap(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int remaining = target - nums[i];
      if (hashMap.containsKey(remaining)) {
        return new int[]{hashMap.get(remaining), i};
      } else {
        hashMap.put(nums[i], i);
      }
    }
    return new int[2];
  }
}
