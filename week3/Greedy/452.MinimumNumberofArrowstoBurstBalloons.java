class Solution {
    public int findMinArrowShots(int[][] points) {
        
        if(points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> (a[1] - b[1] != 0 ? a[1] - b[1] : a[0] - b[0]));
        
        int res = 1;
        int end = points[0][1];
        
        for(int i = 1; i < points.length; i++) {
            
            if(end < points[i][0]) {
                end = points[i][1];
                res++;
            }
            
        }
        return res;
    }
}