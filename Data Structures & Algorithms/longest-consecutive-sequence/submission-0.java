class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        Set<Integer> s = new HashSet<>();

        for(int i : nums)  {
            s.add(i);
        }

        int longest = 0;

        for(int i = 0; i < n; i++) {

            int num = nums[i];

            if(!s.contains(num - 1)) {
                int count = 1;

                while(s.contains(num + 1)) {
                    num++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }


        return longest;
    }
}
