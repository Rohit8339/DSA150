
class Solution { 
    public int evalRPN(String[] tokens) { 
        int n = tokens.length; 
        Stack<Integer> st = new Stack<>(); 
        int i = 0; 
        
        while(i < n) { 
            String s = tokens[i]; 
            
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) { 
                int v2 = st.pop(); 
                int v1 = st.pop(); 
                
                if(s.equals("+")) st.push(v1 + v2); 
                else if(s.equals("-")) st.push(v1 - v2); 
                else if(s.equals("*")) st.push(v1 * v2); 
                else if(s.equals("/")) st.push(v1 / v2); 
            } else { 
                st.push(Integer.parseInt(s)); 
            } 
            i++; 
        } 
        return st.pop(); 
    } 
}
