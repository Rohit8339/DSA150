class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)  {
            
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int index = 0;
        
        for (int pos = bucket.length - 1; pos >= 0 && index < k; pos--) {
            if (bucket[pos] != null) {
                for (int num : bucket[pos]) {
                    if (index < k) {
                        result[index++] = num;
                    }
                }
            }
        }

        return result;
    }
}