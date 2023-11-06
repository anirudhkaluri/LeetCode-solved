class Solution {
    public String decodeString(String s) {
        


        Stack<Data> st=new Stack();
        int n=s.length();
        int i=0;
        String num="";
        while(true){
           // System.out.println("index="+i+"Character="+s.charAt(i));
            if(s.charAt(i)=='['){
                st.push(new Data(i,Integer.parseInt(num),num.length()));
                num="";
            }
            else if(s.charAt(i)==']'){
                 
                Data pop_data=st.pop();
                int open=pop_data.idx;
                int close=i;
                String word=s.substring(open+1,close);
                int cnt=pop_data.count;
                
                String insert="";
                for(int j=0;j<cnt;j++)
                    insert=insert+word;
               // System.out.println("open="+open+" close="+close+" word="+word+" cnt="+cnt+" insert="+insert);
                s=s.substring(0,open-pop_data.count_length)+insert+s.substring(close+1,s.length());
                n=s.length();
                i=open-pop_data.count_length-1+insert.length();
                
            }

            else if(s.charAt(i)>=48 && s.charAt(i)<=57 )
                num=num+String.valueOf(s.charAt(i));
            i++;
            if(i>=n)
                    break;
        }

        return s;


    }
}

class Data{
    int idx, count, count_length;
    Data(int a,int b,int c){
        idx=a;
        count=b;
        count_length=c;
    }
    @Override
    public String toString(){
        return "Index="+String.valueOf(idx)+" count="+String.valueOf(count)+" count_length="+String.valueOf(count_length);
    }
}

