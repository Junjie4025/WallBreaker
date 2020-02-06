class Solution {
    public void reverseString(char[] s) {
        
        if(s == null || s.length <= 1) return;
        
        int lo = 0, hi = s.length - 1;
        
        while(lo < hi) {
            char temp = s[lo];
            s[lo] = s[hi];
            s[hi] = temp;
            lo++;
            hi--;
        }
        
    }
}