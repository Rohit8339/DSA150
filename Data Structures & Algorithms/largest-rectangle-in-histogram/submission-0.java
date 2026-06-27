

class Solution { 
    
    void nextSmaller(int[] heights, int[] nse, Stack<Integer> s, int n) { 
        for(int i = n - 1; i >= 0; i--) { 
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) { 
                s.pop(); 
            } 
            nse[i] = s.isEmpty() ? n : s.peek(); 
            s.push(i); 
        } 
    } 
    
    void prevSmaller(int[] heights, int[] pse, Stack<Integer> s, int n) { 
        for(int i = 0; i < n; i++) { 
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) { 
                s.pop(); 
            } 
            pse[i] = s.isEmpty() ? -1 : s.peek(); 
            s.push(i); 
        } 
    } 
    
    public int largestRectangleArea(int[] heights) { 
        int n = heights.length; 
        
        
        int nse[] = new int[n]; 
        Stack<Integer> s = new Stack<>(); 
        
        nextSmaller(heights, nse, s, n); 
        s.clear(); 
        
        int[] pse = new int[n]; 
        prevSmaller(heights, pse, s, n); 
        
        int maxArea = 0; 
        for(int i = 0; i < n; i++) { 
            
            int width = nse[i] - pse[i] - 1; 
            maxArea = Math.max(maxArea, heights[i] * width); 
        } 
        
        return maxArea; 
    } 
}
