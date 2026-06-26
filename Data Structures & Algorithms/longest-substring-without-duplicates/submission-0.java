class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int maxLength  = 0;

        while(j < n) {

            char c = s.charAt(j);
            if(!map.containsKey(c)) {
                map.put(c, 1);
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
                
            } else {
                char ch = s.charAt(i);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    map.remove(ch);
                }
                i++;
            }
        }

        return maxLength;
        
    }
}
