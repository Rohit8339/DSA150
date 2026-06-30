

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        f(candidates, 0, target, candidates.length);
        return ans;
    }

    void f(int[] candidates, int i, int target, int n) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (i == n || target < 0) {
            return;
        }

        if (target >= candidates[i]) {
            temp.add(candidates[i]);
            f(candidates, i + 1, target - candidates[i], n);
            temp.remove(temp.size() - 1); 
        }

       
        while (i + 1 < n && candidates[i] == candidates[i + 1]) {
            i++;
        }
        
        f(candidates, i + 1, target, n);
    }
}
