class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        if(arr.length<3)return new ArrayList<>();
        Set<ArrayList<Integer>> result=new HashSet<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            if(i>0&&arr[i]==arr[i-1])continue;
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
            ArrayList<Integer>list=new ArrayList<>();
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==0){
                list.add(arr[i]);
                list.add(arr[j]);
                list.add(arr[k]);
                j++;
                k--;
                result.add(list);
                while(j<k&&arr[j]==arr[j-1])j++;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}