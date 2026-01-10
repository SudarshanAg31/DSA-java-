class Solution {
    public int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int count = 0;

        mp.put(0, 1); 

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
