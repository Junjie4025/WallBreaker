class Solution {
    public int binaryGap(int N) {
        
        Integer prev = null;
        int res = 0;
        int idx = 0;
        
        while(N != 0) {
            
            if((N & 1) == 1) {
                if(prev != null) res = Math.max(res, idx - prev);
                prev = idx;
            }
            idx++;
            N >>= 1;
        }
        
        return res;
    }
}