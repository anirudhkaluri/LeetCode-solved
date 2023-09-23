class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
       String[] sent2=sentence2.split("\\s");
       String[] sent1=sentence1.split("\\s");
       int s1p1=0,s1p2=sent1.length-1,s2p1=0,s2p2=sent2.length-1;
       while(s1p1<=s1p2 && s2p1<=s2p2){
           if(sent1[s1p1].equals(sent2[s2p1]) || sent1[s1p2].equals(sent2[s2p2])){
                if(sent1[s1p1].equals(sent2[s2p1]) ){
                    s1p1++;
                    s2p1++;
                }
                if(sent1[s1p2].equals(sent2[s2p2])){
                    s1p2--;
                    s2p2--;
                }
           }
           else
            break;
       }
       if(s1p1<=s1p2 && s2p1<=s2p2)
        return false;
       return true;
       
    }
}