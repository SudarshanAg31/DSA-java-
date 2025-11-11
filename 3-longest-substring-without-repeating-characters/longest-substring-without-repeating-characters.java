//sliding window
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0) {
            return 0;
        }
    Map<Character,Integer>mp=new HashMap<>();
    int st=0;
    int max=0;
    for(int e=0;e<s.length();e++){
        if(!mp.containsKey(s.charAt(e))){
            mp.put(s.charAt(e),1);
            max=Math.max(max,e-st+1);
        }
        else{
            while(mp.containsKey(s.charAt(e))){
            mp.put(s.charAt(st),mp.get(s.charAt(st))-1);
            if(mp.get(s.charAt(st))==0)mp.remove(s.charAt(st));
            st++;
            }
            mp.put(s.charAt(e),1);
        }
    }
    return max;
    }
}