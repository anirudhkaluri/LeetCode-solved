class MagicDictionary {
    TreeSet<String> dict;
    public MagicDictionary() {
        dict=null;
    }
    
    public void buildDict(String[] dictionary) {
        this.dict=new TreeSet<String>(Arrays.asList(dictionary));
    }
    
    public boolean search(String searchWord) {
        int n=searchWord.length();
        for(int i=0;i<n;i++){
            for(char c='a';c<='z';c++){
                if(c!=searchWord.charAt(i)){
                    String temp=searchWord.substring(0,i)+String.valueOf(c)+searchWord.substring(i+1,n);
                    if(dict.contains(temp))
                        return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */