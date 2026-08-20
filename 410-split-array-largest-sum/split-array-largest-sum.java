class Solution {
    public int splitArray(int[] arr, int k) {
        int s = 0;
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            s = Math.max(s, arr[i]);
            e += arr[i];
        }
        int ans = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int count = 1;
            int sum = 0;
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] + sum <= mid) {
                    sum += arr[i];
                } else {
                    count++;
                    sum = arr[i];
                }
                max = Math.max(sum, max);
            }
            if (count <= k) {
                ans = max;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}