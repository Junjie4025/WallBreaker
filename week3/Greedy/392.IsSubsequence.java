class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.isEmpty()) return true;
        
        if(t.isEmpty()) return false;
        
        int is = 0;
        int it = 0;
        
        while(is < s.length() && it < t.length()) {
            
            if(t.charAt(it) == s.charAt(is)) {
                is++;
            }
            it++;
        }
        
        return is == s.length();
    }

    // Solution for follow-up question
    public boolean isSubsequenceFollowUp(String s, String t) {
        
        List<Integer>[] bucket = new List[26];
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(bucket[c - 'a'] == null) bucket[c - 'a'] = new ArrayList<>();
            
            bucket[c - 'a'].add(i);
        } 
        
        int idx = 0;
        for(char c : s.toCharArray()) {
            
            if(bucket[c - 'a'] == null) return false;
            
            int i = Collections.binarySearch(bucket[c - 'a'], idx);
            if(i < 0) i = -i - 1;
            
            if(i >= bucket[c - 'a'].size()) return false;
            
            idx = bucket[c - 'a'].get(i) + 1;
            
        }
        
        return true;
    }
}