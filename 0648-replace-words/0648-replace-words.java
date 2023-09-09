class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        TrieNode root=new TrieNode();
        for(int i=0;i<dictionary.size();i++)
            constructTrie(root,dictionary.get(i));
        String[] str=sentence.split("\s");
        String ans="";
        for(int i=0;i<str.length;i++){
            String rootWord=findRoot(str[i],root);
            ans=ans+rootWord+" ";
        }
        return ans.trim();
    }

    public String findRoot(String str,TrieNode root){
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(root.next[idx]==null)
                break;
            else{
                root=root.next[idx];
                if(root.flag==true)
                    return str.substring(0,i+1);
            }
        }
        return str;
    }

    public void constructTrie(TrieNode root,String str){
        
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(root.next[idx]==null)
                root.next[idx]=new TrieNode();
            root=root.next[idx];
        }
        root.flag=true;
    }
}


class TrieNode{

    TrieNode[] next=new TrieNode[26];
    Boolean flag=false;

    TrieNode(){
        Arrays.fill(next,null);
    }
}