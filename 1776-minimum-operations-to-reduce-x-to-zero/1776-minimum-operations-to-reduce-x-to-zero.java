class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] suf=new int[n];
        pre[0]=nums[0];
        suf[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
            suf[n-i-1]=suf[n-i]+nums[n-i-1];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int key= x-(i>0?pre[i-1]:0);
            if(key==0){
                ans=Math.min(ans,i);
                continue;
            }
            int lo=i,hi=n-1;
            while(lo<=hi){
                int mid=(lo+hi)/2;
                if(suf[mid]==key){
                    ans=Math.min(ans,i+n-mid);
                    break;
                }
                if (suf[mid]>key)
                    lo=mid+1;
                else
                    hi=mid-1;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}