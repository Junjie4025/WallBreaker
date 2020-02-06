class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        
        int count = 1;
        for(int i = n - 1; i >= 0; i--) {
            digits[i] += count;
            count = digits[i] / 10;
            digits[i] %= 10;
            
            if(count == 0) break;
        }
        
        if(count == 0) return digits;
        
        int[] res = new int[n + 1];
        res[0] = count;
        
        return res;
    }
}