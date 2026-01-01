class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]<9){
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        else{
            int x=-1;
            for(int i=digits.length-1;i>=0;i--){
                if(digits[i]!=9){
                    x=i;
                    break;
                }
            }
            if(x!=-1){
            int[] arr=new int[digits.length];
            for(int i=0;i<=x;i++){
                arr[i]=digits[i];    
            }
            arr[x]+=1;
            return arr;
            }
            else{
            int[] arr=new int[digits.length+1];
            arr[0]=1;
            return arr;
            }
        }
    }
}