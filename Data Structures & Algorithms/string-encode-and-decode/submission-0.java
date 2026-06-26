class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        int n = strs.size();

        for(int i = 0; i < n; i++) {
            
            String s  = strs.get(i);
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();

        int i = 0;

        while(i < str.length()) {

            int hashPos = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, hashPos));
            int wordStart = hashPos + 1;
            int wordEnd = wordStart + length;
            ans.add(str.substring(wordStart, wordEnd));

            i = wordEnd;
        }

        return ans;
    }
}
