package 面试题;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: 面试1
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 10 11:23
 * @Version 1.0
 */
/*
*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum

* */
public class 面试1 {
    /*//1. 暴力的方法解决  时间超出限制
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int [2];
        for(int i=0;i<nums.length;i++){
            int num=target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(num==nums[j]){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }*/
    public int[] twoSum(int[] nums, int target) {
        int a[] = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                a[0] = i;
                a[1] = map.get(target - nums[i]);
                return a;
            } else {
                map.put(nums[i], i);
            }
        }
        return a;
    }
}
