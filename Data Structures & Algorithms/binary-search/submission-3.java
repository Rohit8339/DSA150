class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int i = 0;
        int j = n - 1;

        if(n == 1 && nums[0] == target) return 0; 

        while(i  <= j) {

            int mid = i + (j - i) / 2; 

            if(nums[mid] == target) return mid;

            if(nums[mid] > target) j = mid - 1;
            else i = mid + 1;

        }

        return -1;
        
    }
}
