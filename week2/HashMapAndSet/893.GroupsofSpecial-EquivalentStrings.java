class Solution {
    public int numSpecialEquivGroups(String[] A) {
        
        Set<String> set = new HashSet<>();
        
        for(String s : A) {
            
            int[] odd = new int[26];
            int[] even = new int[26];
            for(int i = 0; i < s.length(); i++) {
                if(i % 2 == 0) {
                    even[s.charAt(i) - 'a']++;
                } else {
                    odd[s.charAt(i) - 'a']++;
                }
            }
            
            String hash = Arrays.toString(even) + Arrays.toString(odd);
            set.add(hash);
        }
        
        return set.size();
    }
}