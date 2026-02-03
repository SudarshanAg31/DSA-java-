class Solution {
    public int[] sortArrayByParity(int[] arr) {
        if(arr.length==0)return arr;
        int even=0;
        int odd=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0)even++;
            else odd++;
        }
        int[] even_arr=new int[even];
        int[] odd_arr=new int[odd];
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                even_arr[k]=arr[i];
                k++;
            }
        }
        k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
                odd_arr[k]=arr[i];
                k++;
            }
        }
        for(int i=0;i<even_arr.length;i++){
            arr[i]=even_arr[i];
        }
        k=0;
        for(int i=even_arr.length;i<arr.length;i++){
            arr[i]=odd_arr[k];
            k++;
        }
        return arr;
    }
}