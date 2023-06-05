class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        TreeSet<Integer>ts=new TreeSet<Integer>();
        int n=nums.length;
        HashMap<Integer,Integer>hm=new HashMap();
        for(int i=0;i<n;i++){
            hm.put(nums[i],i);
            int idx=-100000;
            if(hm.containsKey(key))
                idx=hm.get(key);
            if(i-idx<=k)
                ts.add(i);   
        }
        hm.clear();
        for(int i=n-1;i>-1;i--){
            hm.put(nums[i],i);
            int idx=100000;
            if(hm.containsKey(key))
                idx=hm.get(key);
            if(idx-i<=k)
                ts.add(i);   
        }
        List<Integer>ans=new ArrayList(ts);
        return ans;
    }
}