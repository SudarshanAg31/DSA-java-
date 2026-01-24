class Solution {
    public int val(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return 0;
        }
    }
    public int romanToInt(String s) {
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++){
            if((i+1)<n&& val(s.charAt(i))<val(s.charAt(i+1))){
                sum-=val(s.charAt(i));
            }
            else{
                sum+=val(s.charAt(i));
            }
        }
        return sum;
    }
}