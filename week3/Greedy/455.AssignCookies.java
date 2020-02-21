class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int count = 0;
        int ig = 0;
        int is = 0;
        
        while(ig < g.length && is < s.length) {
            
            if(s[is] >= g[ig]) {
                count++;
                ig++;
            }
            is++;
        }
        return count;
    }
}