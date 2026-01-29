class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
       char[]arr = strs[0].toCharArray();
       int len = arr.length;
       //if(strs[strs.length-1]=="") len = len-1;
       for(int i = 1 ; i<strs.length ; i++){
        char[]arr2 = strs[i].toCharArray();
           int minlen = Math.min(len , arr2.length);
           for(int j = 0 ; j<minlen ; j++){
            if(arr[j]!=arr2[j]){
                len  = j;
                break;
            }
            if(j==minlen-1){
                len = minlen;
            }
           }
           if(strs[i].length()==0) return "";
           if(len==0) return "";
        
       }
      return new String(arr,0,len);

        }
    }