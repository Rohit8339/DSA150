class Solution { 
    public String minWindow(String s, String t) { 
        int m = s.length(); 
        int n = t.length(); 
        
        if (m < n) return ""; 
        
        int[] hash = new int[256]; 
        for (int i = 0; i < n; i++) { 
            hash[t.charAt(i)]++; 
        } 
        
        int i = 0; 
        int j = 0; 
        int count = 0; 
        int si = -1; 
        int minLength = Integer.MAX_VALUE; 
        
        while (j < m) { 
            char rightChar = s.charAt(j);
            
            if (hash[rightChar] > 0) { 
                count++; 
            } 
            hash[rightChar]--; 
            
            while (count == n) { 
                if (j - i + 1 < minLength) { 
                    minLength = j - i + 1; 
                    si = i; 
                } 
                
                char leftChar = s.charAt(i);
                hash[leftChar]++; 
                
                if (hash[leftChar] > 0) { 
                    count--; 
                } 
                i++; 
            } 
            j++; 
        } 
        
        return (si == -1) ? "" : s.substring(si, si + minLength); 
    } 
}
