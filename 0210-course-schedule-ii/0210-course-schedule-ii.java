class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans=new int[numCourses];
        int p=0;
         //construct queue for courses whose outdegrees are 0
        Queue<Integer> q=new LinkedList();
        HashSet<Integer>hs=new HashSet();
        //construct outdegree hashmap
        HashMap<Integer,Integer>hm=new HashMap();
        //construct Indegree adjacency matrix
        ArrayList<Integer>[] indegree=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            indegree[i]=new ArrayList<Integer>();
            hs.add(i);
        }
       

        int[][] pre=prerequisites;
        int cnt=pre.length;
        for(int i=0;i<cnt;i++){
            hm.merge(pre[i][0],1,(v1,v2)->v2=v1+1);
            hs.remove(pre[i][0]);
            indegree[pre[i][1]].add(pre[i][0]);
        }

        q.addAll(hs);
        while(q.size()>0){
            int node=q.remove();
            ans[p++]=node;
            for(int i=0;i<indegree[node].size();i++){
                int val=indegree[node].get(i);
                hm.merge(val,0,(v1,v2)->v2=v1-1);
                if(hm.get(val)==0){
                    q.add(val);
                    hm.remove(val);
                }
            }
        }

        if(p==numCourses)
            return ans;
        int[] emp=new int[0];
        return emp;
    }
}