class Solution {
    public char findTheDifference(String s, String t) {
        
        int[] bucket = new int[26];
        
        for(char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        
        for(char c : t.toCharArray()) {
            bucket[c - 'a']--;
            
            if(bucket[c - 'a'] < 0) return c;
        }
        
        return '!';
    }
}