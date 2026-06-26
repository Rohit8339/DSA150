

class Solution { 
    public List<List<Integer>> threeSum(int[] numbers) { 
        int n = numbers.length; 
        Set<List<Integer>> ans = new HashSet<>(); 
        
        Arrays.sort(numbers); 
        
        for (int k = 0; k < n - 2; k++) { 
            int i = k + 1; 
            int j = n - 1; 
            
            while (i < j) { 
                int sum = numbers[k] + numbers[i] + numbers[j];
                
                if (sum == 0) { 
                    ans.add(Arrays.asList(numbers[k], numbers[i], numbers[j]));
                    i++;
                    j--;
                } else if (sum < 0) { 
                    i++; 
                } else { 
                    j--; 
                } 
            } 
        } 
        return new ArrayList<>(ans); 
    } 
}
