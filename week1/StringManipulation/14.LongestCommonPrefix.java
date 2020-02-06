class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0) return "";
        
        if(strs.length == 1) return strs[0];
        
        int res = strs[0].length() - 1;
        
        for(int i = 1; i < strs.length; i++) {
            int max = -1;
            
            for(int j = 0; j < Math.min(strs[0].length(), strs[i].length()); j++) {
                if(strs[0].charAt(j) == strs[i].charAt(j)) max = j;
                else break;
            }
            
            res = Math.min(res, max);
        }
        
        return strs[0].substring(0, res + 1);
    }
}