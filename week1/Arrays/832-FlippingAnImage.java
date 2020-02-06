class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        int m = A.length;
        int n = A[0].length;
        
        for(int i = 0; i < m; i++) {
            reverseAndFlip(A[i]);
        }
        
        return A;
    }
    
    private void reverseAndFlip(int[] A) {
        
        int lo = 0;
        int hi = A.length - 1;
        
        while(lo < hi) {
            int temp = A[lo];
            A[lo] = A[hi] == 1 ? 0 : 1;
            A[hi] = temp == 1 ? 0 : 1;
            lo++;
            hi--;
        }
        
        if(lo == hi) A[lo] = A[lo] == 1 ? 0 : 1;
    }
}