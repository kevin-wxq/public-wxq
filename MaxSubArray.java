package labuladong.dp;

//最大子数组问题
//输入一个整数数组nums，请在其中找一个和最大的子数组，返回这个数组的和
//输入nums=[-3,1,3,-1,2,-4,2]
//dp数组的定义为：以nums[i]为结尾的“最大子数组的和”为dp[i]
//时间复杂度为O(n),空间复杂度为O(n)
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums=new int[]{-3,1,3,-1,2,-4,2};
        int res=maxSubArray(nums);
        System.out.println(res);
    }

    //dp[i]有两种选择，要么与前面相邻的子数组连接，形成一个和更大的子数组，
    // 要么不与前面的子数组连接，自成一派，自己作为一个数组
    private static int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        int[] dp=new int[n];
        //base case:第一个元素前面没有子数组
        dp[0]=nums[0];
        //状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
        }
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    //优化   状态压缩
    public int maxSubArray1(int[] nums){
        int n=nums.length;
        if(n==0){
            return 0;
        }
        //base case
        int dp_0=nums[0];
        int dp_1=0,res=dp_0;
        for (int i = 0; i < n; i++) {
            //dp[i]=max(nums[i],nums[i]+dp[i-1])
            dp_1=Math.max(nums[i],nums[i]+dp_0);
            dp_0=dp_1;
            res=Math.max(res,dp_1);
        }
        return res;
    }

}
