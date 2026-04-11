class Solution {
    public String trafficSignal(int time) {
       if(time==0)return "Green";
       if(time==30)return "Orange";
       if(time>30&&time<=90)return "Red";
       else return "Invalid"; 
    }
}