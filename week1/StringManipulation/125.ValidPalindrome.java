class Solution {
    public boolean isPalindrome(String s) {
        
        if(s == null || s.length() <= 1) return true;
        
        char[] arr = s.toCharArray();
        int lo = 0, hi = arr.length - 1;
        
        while(lo < hi) {
            
            while(lo < hi && !Character.isAlphabetic(arr[lo]) && !Character.isDigit(arr[lo])) lo++;
            
            while(lo < hi && !Character.isAlphabetic(arr[hi]) && !Character.isDigit(arr[hi])) hi--;
            
            if(lo < hi) {
                if(Character.isAlphabetic(arr[lo])) arr[lo] = Character.toLowerCase(arr[lo]);
                if(Character.isAlphabetic(arr[hi])) arr[hi] = Character.toLowerCase(arr[hi]);
                if(arr[lo] != arr[hi]) return false;
                
                lo++;
                hi--;
            }
            
        }
        
        return true;
    }
}