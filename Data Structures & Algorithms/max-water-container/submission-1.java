class Solution {
    public int maxArea(int[] h) {

        int n = h.length;

        int maxWater = Integer.MIN_VALUE;

        /*  n^2

        for(int i = 0; i < n; i++) {

            for(int j = i + 1; j < n; j++) {

                int height = Math.min(h[i], h[j]);
                int weidth = j - i;
                maxWater = Math.max(maxWater, (height * weidth));

            }

            
        }
        */

        int i = 0;
        int j = n - 1;

        while(i < j) {
            int height = Math.min(h[i], h[j]);
            int weidth = j - i;
            maxWater = Math.max(maxWater, (height * weidth));

            if(h[i] < h[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}
