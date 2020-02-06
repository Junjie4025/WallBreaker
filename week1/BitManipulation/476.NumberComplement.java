class Solution {
    public int findComplement(int num) {
        
        int res = (num & 1) == 1 ? 0 : 1;
        
        int i = 0;
        while(num >> 1 != 0) {
            num = num >> 1;
            i++;
            
            if((num & 1) == 0) {
                res = res | (1 << i);
            }
            
        }
        
        return res;
    }
}