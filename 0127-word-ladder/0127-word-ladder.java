class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        int len=beginWord.length();
        Boolean[][] graph=new Boolean[n][n];
        HashMap<String,Integer>hm=new HashMap();
        int flag=0;
        for(int i=0;i<n;i++){
            hm.put(wordList.get(i),i);
            Arrays.fill(graph[i],Boolean.FALSE);
        }

        if(!hm.containsKey(endWord))
            return 0;

        
        //make the graph
        for(int i=0;i<n;i++){
            String word=wordList.get(i);
            
            for(int j=0;j<len;j++){
                for(char k='a';k<='z';k++){
                     String createdWord= word.substring(0,j)+String.valueOf(k)+word.substring(j+1,len);
                     if(hm.containsKey(createdWord) && !(word.equals(createdWord)))
                        graph[i][hm.get(createdWord)]=true;
                }
               
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(graph[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        Queue<Integer>q=new LinkedList();
        Boolean[] vis=new Boolean[n];
        Arrays.fill(vis,Boolean.FALSE);
        if(hm.containsKey(beginWord))
            vis[hm.get(beginWord)]=true;
        for(int j=0;j<len;j++){
    
            for(char k='a';k<='z';k++){
                String createdWord=beginWord.substring(0,j)+String.valueOf(k)+beginWord.substring(j+1,len);
                if(hm.containsKey(createdWord))
                    if(!vis[hm.get(createdWord)]){
                        int idx=hm.get(createdWord);
                        q.add(idx);
                        vis[idx]=true;
                    }
            }

        }
        q.add(null);
        System.out.println(q);
        int ans=2;
        while(q.size()>0){
            int node=q.peek()==null?-1:q.peek();
            q.remove();
            System.out.println("We are considering the word :"+node);
            if(node!=-1){
                if(endWord.equals(wordList.get(node))){
                    flag=1;
                    
                }
                for(int j=0;j<n;j++){
                    if(graph[node][j]==true && !vis[j]){
                        vis[j]=true;
                        q.add(j);
                        if(endWord.equals(wordList.get(j))){
                                ans++;
                              flag=1;
                            break;
                          
                        }

                    }
                }
                if(flag==1)
                    break;
            }
            else{
                if(q.size()>0)
                    q.add(null);
                ans++;
            }
        }

        if(flag==0)
            return 0;
        return ans;
        
        
    }
}