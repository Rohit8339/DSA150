class Solution { 
    long f(int bananas, int[] piles) { 
        long totalh = 0; 
        for(int i = 0; i < piles.length; i++) { 
            totalh += piles[i] / bananas; 
            if(piles[i] % bananas != 0) {
                totalh++; 
            }
        } 
        return totalh; 
    } 

    public int minEatingSpeed(int[] piles, int h) { 
        int n = piles.length; 
        int i = 1; 
        int j = 0; 
        
        for(int k = 0; k < n; k++) {
            j = Math.max(j, piles[k]);
        }
        
        int minBananas = j; 
        
        while(i <= j) { 
            int mid = i + (j - i) / 2; 
            long totalH = f(mid, piles); 
            
            if(totalH <= h) { 
                minBananas = mid; 
                j = mid - 1; 
            } else { 
                i = mid + 1; 
            } 
        } 
        return minBananas; 
    } 
}
