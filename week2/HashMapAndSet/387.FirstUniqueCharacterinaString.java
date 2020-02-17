class Solution {
    public int firstUniqChar(String s) {
        
        int[] bucket = new int[26];
        
        for(char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(bucket[s.charAt(i) - 'a'] < 2) return i;
        }
        
        return -1;
    }
}