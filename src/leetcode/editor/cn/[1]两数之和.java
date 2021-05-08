class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        int i;
        int[] result = new int[2];
        for (i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                int a = i;
                int b = hashMap.get(target - nums[i]);
                if (a == b) {
                    continue;
                }
                if (a > b) {
                    result[0] = b;
                    result[1] = a;
                } else {
                    result[0] = a;
                    result[1] = b;
                }
                break;
            }
        }
        return result;
    }
}
