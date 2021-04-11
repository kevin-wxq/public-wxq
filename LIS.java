package labuladong.dp;


import java.util.Arrays;

//最长增长子序列
/*
输入：nms=[10,9,2,5,3,7,101,18]        最长增长子序列：[2,3,7,101]
输出：4
 */
public class LIS {

    public static void main(String[] args) {
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        int res=lengthOfLIS(nums);
        System.out.println(res);
    }

    //动态规划解法
    //dp[i]的定义表示为以nums[i]这个数结尾的最长递增子序列的长度
    //时间复杂度O（n2）

    public static int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        //base case:dp数组全部初始化为1
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for (int i = 0; i < dp.length; i++) {
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    //二分搜索解法
    //耐心排序
    //时间复杂度O（nlogn）
    public static int lengthOfLIS1(int[] nums){
        int[] top =new int[nums.length];
        int piles=0;
        for (int i = 0; i < nums.length; i++) {
            //要处理的扑克牌
            int poker=nums[i];
            //搜索左侧边界的二分查找
            int left=0,right=piles;
            while(left<right){
                int mid=(left+right)/2;
                if(top[mid]>poker){
                    right=mid;
                }else if(top[mid]<poker){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            /******************************************************/
            //没找到合适的牌堆，新建一堆
            if (left==piles)
                piles++;
            top[left]=poker;
        }
        return piles;
    }

}
