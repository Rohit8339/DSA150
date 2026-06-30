class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        f(nums, 0, nums.length);
        return ans;
    }

    void f(int nums[], int i, int n) {
        if(i == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);

        f(nums, i+1, n);

        temp.remove(temp.size() - 1);

        while(i + 1 < n && nums[i] == nums[i+1]) {
            i++;
        }

        f(nums, i+1, n);
    }
}
