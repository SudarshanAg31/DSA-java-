import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Set<ArrayList<Integer>>result=new HashSet<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-3;i++){
            if(i>0&&arr[i]==arr[i-1])continue;
            for(int j=i+1;j<arr.length-2;j++){
                if(j>i+1&&arr[j]==arr[j-1])continue;
                int s=j+1;
                int e=arr.length-1;
                while(s<e){
                    long sum=(long)arr[i]+arr[j]+arr[s]+arr[e];
                    if(sum==target){
                        ArrayList<Integer>list=new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[s]);
                        list.add(arr[e]);
                        s++;
                        e--;
                        result.add(list);
                        while(s<e&&arr[s]==arr[s-1])s++;
                    }
                    else if(sum>target){
                        e--;
                    }
                    else{
                        s++;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}