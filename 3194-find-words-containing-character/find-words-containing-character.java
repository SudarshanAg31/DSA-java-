class Solution {
    public List<Integer> findWordsContaining(String[] arr, char x) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int z=arr[i].length();
            int y=0;;
            for(int j=0;j<z;j++){
                char ch=arr[i].charAt(j);
                if(ch==x){
                    y=1;
                    break;
                }
            }
            if(y==1){
                ans.add(i);
            }
        }
        return ans;
    }
}