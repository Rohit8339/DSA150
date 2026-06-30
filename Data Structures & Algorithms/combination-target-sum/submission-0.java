

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    void f(int[] nums, int i, int target, int n) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (i == n || target < 0) {
            return;
        }

        if (target >= nums[i]) {
            temp.add(nums[i]);
            f(nums, i, target - nums[i], n); 
            temp.remove(temp.size() - 1); 
        }

        f(nums, i + 1, target, n);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        f(nums, 0, target, nums.length);
        return ans; 
    }
}
