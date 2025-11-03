class Solution {
    public int minCost(String str, int[] arr) {
        int s = 0;
        int i = 0;
        int max = 0;
        int total = 0;
        while(i < str.length() - 1) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
                max = arr[i]; 
            } else {
                max = 0; 
            }
            while(i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
                max = Math.max(max, arr[i+1]);
                i++;
            }
            if(max != 0) { 
                int groupTotal = 0;
                while(s <= i) {
                    groupTotal += arr[s];
                    s++;
                }
                total += (groupTotal - max); 
                max = 0; 
            } else {
                 s++;
            }
            i++;
        }
        return total;
    }
}