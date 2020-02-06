class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int lo = 0;
        int hi = A.length - 1;
        
        while(lo < hi) {
            
            if(A[lo] % 2 != 0) {
                swap(A, lo, hi);
                hi--;
            } else {
                lo++;
            }
        }
        
        return A;
    }
    
    private void swap(int[] A, int lo, int hi) {
        
        int temp = A[lo];
        A[lo] = A[hi];
        A[hi] = temp;
        
    }
}
