class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        Map<Character,Integer>mp=new HashMap<>();
        int sum=0;
        for(int i=0;i<s1.length();i++){
            if(!mp.containsKey(s1.charAt(i))){
            mp.put(s1.charAt(i),1);
            }
            else{
            mp.put(s1.charAt(i),mp.get(s1.charAt(i))+1);
            }
            sum+=(int)s1.charAt(i);
        }
        int temp=0;
        for(int i=0;i<s1.length();i++){
            temp+=(int)s2.charAt(i);
        }
        int e=s1.length()-1;
    for(int i=0;i<=s2.length()-s1.length();i++){
        if(temp==sum){
            int x=i;
            Map<Character,Integer>check = new HashMap<>(mp);
            while(x<s2.length()&&check.containsKey(s2.charAt(x))){
                check.put(s2.charAt(x),check.get(s2.charAt(x))-1);
                if(check.get(s2.charAt(x))==0){
                    check.remove(s2.charAt(x));
                }
                x++;
                if(check.size()==0){
                    return true;
                }
            }
        }   
            e++;
            if(e<s2.length())
            temp=temp-(int)s2.charAt(i)+(int)s2.charAt(e);
        }
        return false;
    }
}