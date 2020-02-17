class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        String[] arr = str.split(" ");
        
        if(arr.length != pattern.length()) return false;
        
        Map<Character, Integer> mapPattern = new HashMap<>();
        Map<String, Integer> mapString = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            
            char c = pattern.charAt(i);
            String s = arr[i];
            
            if(mapPattern.containsKey(c) && mapString.containsKey(s)) {
                if(Integer.compare(mapPattern.get(c), mapString.get(s)) != 0) return false;
            } else if(mapPattern.containsKey(c) ^ mapString.containsKey(s)) {
                return false;
            }
            
            mapPattern.put(c, i);
            mapString.put(s, i);
            
        }
        
        return true;
    }
}