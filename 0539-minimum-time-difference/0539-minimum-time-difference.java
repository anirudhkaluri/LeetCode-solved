class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Time> pts=new ArrayList();
        for(int i=0;i<timePoints.size();i++){
            String time=timePoints.get(i);
            String[] str=time.split(":");
            pts.add(new Time(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
        }
        Collections.sort(pts,new TimeComp());
        System.out.println(pts);
        int ans=Integer.MAX_VALUE;
        int n=pts.size();
        for(int i=1;i<=pts.size();i++){
            Time prev=pts.get(i-1);
            Time cur=pts.get(i%n);
            int diff= Math.abs(((cur.hours*60)+cur.minutes)-((prev.hours*60)+prev.minutes));
            int diff2=(24*60)-diff;
            ans=Math.min(Math.min(ans,diff),diff2);
        }
        
        return ans;
    }
}

class TimeComp implements Comparator<Time>{
    public int compare(Time a,Time b){
        if(a.hours>b.hours)
            return 1;
        if(b.hours>a.hours)
            return -1;
        if(a.minutes<b.minutes)
            return -1;
        return 1;
    }
}

class Time{
    int hours,minutes;
    Time(int a,int b){
        hours=a;
        minutes=b;
    }
    @Override
    public String toString()
    {
        return String.valueOf(hours)+":"+String.valueOf(minutes);
    }
}

