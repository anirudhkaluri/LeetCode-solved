class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int[][] arr=new int[n][26];
       
        for(int i=0;i<n;i++){
            for(int k=0;k<26;k++)
                arr[i][k]=i-1>=0?arr[i-1][k]:0;
            arr[i][s.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            System.out.println("\n");
            for(int j=0;j<26;j++)
                System.out.print(arr[i][j]+",");
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(arr[j][k]!=0){
                        int val=arr[j][k]-(i-1>-1?arr[i-1][k]:0);
                        if(val!=0){
                        max=Math.max(max,val);
                        min=Math.min(min,val);
                        }
                    }
                }
              //  System.out.println("From i="+i+" to j="+j+" max="+max+" min="+min);
                sum=max-min+sum;
            }
        }
        return sum;
    }
}