class Solution {
    public int[] dailyTemperatures(int[] t) {

        int n = t.length;
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();


        for(int i = n - 1; i >= 0; i--) {

            while(!s.isEmpty() && t[s.peek()] <= t[i]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? 0 : s.peek() - i; 

            s.push(i);

            
        }

        return ans;
        
    }
}
