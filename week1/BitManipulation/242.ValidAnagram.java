class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        int[] bucket = new int[26];
        
        for(char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        
        for(char c : t.toCharArray()) {
            if(bucket[c - 'a'] == 0) return false;
            
            bucket[c - 'a']--;
        }
        
        return true;
    }
}