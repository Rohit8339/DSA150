class Solution {
    public boolean isAnagram(String s, String t) {

        int n = s.length();
        int m  = t.length();

        if(n != m) return false;

        Map<Character, Integer> map  = new HashMap<>();

        for(int i = 0; i < n;  i++)  {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        

        for(int i = 0; i < m; i++) {
            char c = t.charAt(i);

            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }

        return map.isEmpty();

    }
}
