class Solution {
    public String intToRoman(int num) {
        String[] symbols={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] value={1,4,5,9,10,40,50,90,100,400,500,900,1000};
        HashMap<Integer,String>hm=new HashMap();
        // hm.put(4,"IV");
        // hm.put(9,"IX");
        // hm.put(40,"XL");
        // hm.put(90,"XC");
        // hm.put(400,"CD");
        // hm.put(900,"CM");
        String ans="";
        for(int i=symbols.length-1;i>=0 && num>0;i--){
            int cnt=num/value[i];
            num=num-(value[i]*cnt);
            for(int j=1;j<=cnt;j++)
                ans=ans+symbols[i];
            // if(hm.containsKey(num)){
            //     ans=ans+hm.get(num);
            //     break;
            // }
        }
        return ans;
    }

   
}