class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(mapS.containsKey(c1) && mapT.containsKey(c2)) {
                if(mapS.get(c1) != mapT.get(c2)) return false;
            } else if(!mapS.containsKey(c1) && !mapT.containsKey(c2)) {
                mapS.put(c1, i);
                mapT.put(c2, i);
            } else {
                return false;
            }
            
        }
        
        return true;
    }
}