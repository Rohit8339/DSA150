
class Solution {
    
    List<Integer> temp = new ArrayList<>(); 

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans, nums.length); 
        return ans;
    } 

    void f(int[] nums, int i, List<List<Integer>> ans, int n) { 
        if (i == n) { 
            ans.add(new ArrayList<>(temp)); 
            return; 
        } 
        
        temp.add(nums[i]); 
        f(nums, i + 1, ans, n); 
        
        temp.remove(temp.size() - 1); 
        f(nums, i + 1, ans, n); 
    }
}
