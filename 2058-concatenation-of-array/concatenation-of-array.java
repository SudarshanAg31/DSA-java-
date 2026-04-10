class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length * 2];
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (a == nums.length)
                a = 0;
            arr[i] = nums[a];
            a++;
        }
        return arr;
    }
}