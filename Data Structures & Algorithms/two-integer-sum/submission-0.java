class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        
        //O(n*n)

        // for(int i = 0; i < n;  i++)  {
        //     for(int j = i + 1; j < n; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }

        Map<Integer, Integer> map  = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(map.containsKey((target - nums[i]))){
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
        
    }
}
