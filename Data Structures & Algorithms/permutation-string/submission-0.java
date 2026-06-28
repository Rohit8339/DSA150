class Solution { 
    public boolean checkInclusion(String s1, String s2) { 
        int n = s1.length(); 
        int m = s2.length(); 
        
        if (n > m) return false;

        int[] freq1 = new int[26]; 
        int[] freq2 = new int[26]; 
        
        for(int i = 0; i < n; i++) { 
            freq1[s1.charAt(i) - 'a']++; 
        } 
        
        int i = 0; 
        int j = 0; 
        
        while(j < m) { 

            freq2[s2.charAt(j) - 'a']++;
            
        
            if (j - i + 1 == n) {
                
                boolean isMatch = true;
                for (int k = 0; k < 26; k++) {
                    if (freq1[k] != freq2[k]) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) return true;
                
                freq2[s2.charAt(i) - 'a']--;
                i++; 
            } 
            
            
            j++; 
        } 
        
        return false; 
    } 
}
