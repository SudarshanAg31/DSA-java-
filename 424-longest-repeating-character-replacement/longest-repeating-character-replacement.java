class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer>mp=new HashMap<>();
        int maxfq=0;
        int max=0;
        int st=0;
        for(int e=0;e<s.length();e++){
            if(!mp.containsKey(s.charAt(e))){
                mp.put(s.charAt(e),1);
            }
            else{
                mp.put(s.charAt(e),mp.get(s.charAt(e))+1);
            }
            maxfq=Math.max(maxfq,mp.get(s.charAt(e)));
            while((e-st+1)-maxfq>k){
                mp.put(s.charAt(st),mp.get(s.charAt(st))-1);
                st++;
            }
            max=Math.max(max,e-st+1);
        }
        return max;
    }
}