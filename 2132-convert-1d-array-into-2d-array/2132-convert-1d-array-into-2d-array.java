class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans=new int[m][n];
        int[][] alternate=new int[0][0];
        int len=original.length;
        if(len!=m*n)
            return alternate;
        for(int i=0;i<original.length;i++)
            ans[i/n][i%n]=original[i];
        return ans;
    }
}