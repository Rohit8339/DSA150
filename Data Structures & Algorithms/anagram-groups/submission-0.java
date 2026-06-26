class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        

        Map<String, List<String>> map  = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c); 

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(s);
        }

    

    return new ArrayList<>(map.values());
        
    }
}
