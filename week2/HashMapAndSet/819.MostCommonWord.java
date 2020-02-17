class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        
        int max = 0;
        String res = "";
        
        int lo = 0, hi = 0;
        while(hi < paragraph.length()) {
            
            
            while(hi < paragraph.length() && !Character.isAlphabetic(paragraph.charAt(hi))) hi++;
            
            lo = hi;
            
            while(hi < paragraph.length() && Character.isAlphabetic(paragraph.charAt(hi))) hi++;
            
            String word = paragraph.substring(lo, hi).toLowerCase();
            
            if(set.contains(word)) continue;
            
            map.put(word, map.getOrDefault(word, 0) + 1);
            
            if(map.get(word) > max) {
                max = map.get(word);
                res = word;
            }
            
        }
        
        return res;
    }
}