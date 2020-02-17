class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int count = 0;
        int[] bucket = new int[26];
        for(char c : p.toCharArray()) {
            bucket[c - 'a']++;
            if(bucket[c - 'a'] == 1) count++;
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']--;
            if(bucket[s.charAt(i) - 'a'] == 0) count--;
            else if(bucket[s.charAt(i) - 'a'] == -1) count++;
            
            if(i >= p.length()) {
                bucket[s.charAt(i - p.length()) - 'a']++;
                if(bucket[s.charAt(i - p.length()) - 'a'] == 0) count--;
                else if(bucket[s.charAt(i - p.length()) - 'a'] == 1) count++;
            }
            
            if(count == 0) res.add(i - p.length() + 1);
        }
        
        return res;
    }
}