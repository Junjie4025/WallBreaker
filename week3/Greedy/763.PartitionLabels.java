class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> res = new ArrayList<>();
        
        if(S.isEmpty()) return res;
        
        int[] bucket = new int[26];
        Arrays.fill(bucket, -1);
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            bucket[c - 'a'] = i;
        }
        
        int i = 0;
        int j = 0;
        while(j < S.length()) {
            
            char c = S.charAt(j);
            int max = bucket[c - 'a'];
            while(j < max && j < S.length()) {
                j++;
                max = Math.max(max, bucket[S.charAt(j) - 'a']);
            }
            
            res.add(j - i + 1);
            j++;
            i = j;
        }
        
        return res;
    }
}