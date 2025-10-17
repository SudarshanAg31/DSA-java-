import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1)return strs[0];
        if(strs.length==0||strs[0]==null)return "";
        StringBuilder ans = new StringBuilder();
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && str.charAt(i) == strs[j].charAt(i)) {
                    count++;
                    if (count == strs.length) {
                        ans.append(str.charAt(i));
                    }
                } else {
                    return ans.toString();
                }
            }
        }
        return ans.toString();
    }
}