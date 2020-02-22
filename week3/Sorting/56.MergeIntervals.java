class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0) return intervals;
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        List<int[]> res = new ArrayList<>();
        
        int lo = 0;
        int hi = lo + 1;
        while(hi < intervals.length) {
            
            if(intervals[lo][1] >= intervals[hi][0]) {
                intervals[lo][1] = Math.max(intervals[lo][1], intervals[hi][1]);
            }
            else {
                res.add(intervals[lo]);
                lo = hi;
            }
            hi++;
        }
        
        res.add(intervals[lo]);
        
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}