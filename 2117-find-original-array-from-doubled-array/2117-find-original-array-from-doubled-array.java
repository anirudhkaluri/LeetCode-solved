class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        int[] alternate=new int[0];
        int[] ans=new int[n/2];
        int p=0;
        if(n%2==1)
            return alternate;
        TreeMap<Integer,Integer> tm=new TreeMap();
        for(int i:changed)
            tm.merge(i,1,(v1,v2)->v2=v1+1);
       
        while(tm.size()>0){
            Map.Entry<Integer,Integer> entry=tm.pollFirstEntry();
            int key=entry.getKey();
            int value=entry.getValue();
            if(key==0){
                if(value%2==0){
                    for(int i=0;i<value/2;i++){
                        ans[p++]=0;
                    }
                }
                else
                    return alternate;
            }
            else if(tm.containsKey(key*2)){
                int doubled_key=key*2;
                int doubled_value=tm.get(doubled_key);
                if(value<=doubled_value){
                    for(int i=0;i<value;i++)
                        ans[p++]=key;
                    tm.remove(key);
                    tm.merge(doubled_key,0,(v1,v2)->v2=v1-value);
                    if(tm.get(doubled_key)==0)
                        tm.remove(doubled_key);
                }
                else
                    return alternate;
            }
            else
                return alternate;
        }
        return ans;
    }
}