package com.wx.leetcode.p1;

import com.wx.leetcode.util.Util;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of
 * the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * T(n) = O(n)
 * S(n) = O(n)
 * @author weixing
 * @date 2019/1/1
 **/
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        int[] res = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Util.print(twoSum(new int[]{2, 7, 11, 12}, 9));
    }
}
