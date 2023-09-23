class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int nq=queries.length;
        int[] ans=new int[nq];
        TreeMap<Integer,Integer> wmap=new TreeMap();
        for(int i=0;i<words.length;i++){
            int fs=findFreq(words[i]);
            wmap.merge(fs,1,(v1,v2)->v2=v1+1);
        }
        List<pair> al=new ArrayList<pair>();
        for(Map.Entry<Integer,Integer>entry:wmap.entrySet()){
            pair temp=new pair(entry.getKey(),entry.getValue());
            al.add(temp);
        }
        Collections.sort(al,new paircomp());
   
        int[] pre=new int[al.size()];
        for(int i=0;i<al.size();i++){
            pair temp=al.get(i);
            if(i==0)
                pre[0]=temp.word_count;
            else
                pre[i]=pre[i-1]+temp.word_count;
          
        }
        for(int i=0;i<nq;i++){
            int fs=findFreq(queries[i]);
         
            int lo=0,hi=al.size()-1;
            int idx=-1;
            while(lo<=hi){
                int mid=(lo+hi)/2;
                pair temp=al.get(mid);
                if(fs<temp.freq_lex_small){
                    idx=mid;
                    hi=mid-1;
                }
                else
                    lo=mid+1;
            }
            if(idx==-1)
                ans[i]=0;
            else
                ans[i]=pre[al.size()-1]-(idx-1>-1?pre[idx-1]:0);
        }
        return ans;


    }

    public int findFreq(String word){
        TreeMap<Character,Integer> tm=new TreeMap();
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            tm.merge(c,1,(v1,v2)->v2=v1+1);
        }
        return tm.firstEntry().getValue();
    }
}

class paircomp implements Comparator<pair>{
    public int compare(pair o1,pair o2){
        if(o1.freq_lex_small>o2.freq_lex_small)
            return 1;
        return -1;
    }
}


class pair{
    int word_count,freq_lex_small;
    pair(int a,int b){
        freq_lex_small=a;
        word_count=b;
    }
    @Override
    public String toString(){
        return "freq_lex_small="+String.valueOf(freq_lex_small)+" frequency="+String.valueOf(word_count);
    }
}

/* 
object(f(words),frequency)
ArrayList<objects>
Sort objects based on f(words)
Find prefix of frequency
For every words in queries, find strict ceil of f(queries[i])
<F(words),frequency>

*/