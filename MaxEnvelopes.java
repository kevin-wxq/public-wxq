package labuladong.dp;


import java.util.Arrays;
import java.util.Comparator;

//二维递增子序列：信封嵌套问题
//给出一些信封，每个信封用高度和宽度的整数对形式（w,h）表示当一个信封A的高度和宽度都比另一个信封B大的时候，
// 则B就可以放进A里，如同“俄罗斯套娃”请计算最多有多少个信封能组成一组“俄罗斯套娃”信封（即最多能套几层）
//输入：envelopes=[[5,4],[6,4],[6,7],[2,3]]
//时间复杂度O(nlogn)，空间复杂度为O(n);
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int res = maxEnvelopes(envelopes);
        System.out.println(res);
    }

    private static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] height=new int[n];
        for (int i = 0; i < n; i++) {
            height[i]=envelopes[i][1];
        }
        return LIS.lengthOfLIS(height);
//        return LIS.lengthOfLIS1(height);
    }
}
