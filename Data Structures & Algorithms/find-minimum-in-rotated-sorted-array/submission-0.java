class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int ans = Integer.MAX_VALUE;

        int mini = Integer.MAX_VALUE;
        

        while(i <= j) {
            int mid = i + (j - i)  / 2;

            if(nums[mid]  <= nums[j]) {
                ans = Math.min(ans, nums[mid]);
                j = mid  - 1;
            } else {
                ans = Math.min(ans, nums[i]);
                i = mid + 1;
            }
        }
        return ans;
    }
}
