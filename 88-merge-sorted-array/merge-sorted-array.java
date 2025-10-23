class Solution {
    public void merge(int[] arr, int m, int[] arr1, int n) {
        if(m==0){
            for(int i=0;i<arr.length;i++)arr[i]=arr1[i];
            return;
        }
        if(n==0){
            return;
        }
        int r1=m-1;
        int r2=n-1;
        int w=n+m-1;
        while(r2>=0){
            if(r1>=0&&arr[r1]>=arr1[r2]){
                arr[w]=arr[r1];
                r1--;
            }
            else{
                arr[w]=arr1[r2];
                r2--;
            }
            w--;
        }
    }
}