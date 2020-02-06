class Solution {
    public String reverseWords(String s) {
        
        if(s == null || s.length() <= 1) return s;
        
        char[] arr = s.toCharArray();
        
        int lo = 0, hi = 0;
        while(hi < arr.length) {
            
            while(hi < arr.length && arr[hi] != ' ') hi++;
            
            reverse(arr, lo, hi - 1);
            
            hi++;
            lo = hi;
        }
        
        return new String(arr);
    }
    
    private void reverse(char[] arr, int lo, int hi) {
        
        while(lo < hi) {
            char temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
        
    }
}