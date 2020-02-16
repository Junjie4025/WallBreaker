class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        for(String s : A.split(" ")) {
            mapA.put(s, mapA.getOrDefault(s, 0) + 1);
        }
        for(String s : B.split(" ")) {
            mapB.put(s, mapB.getOrDefault(s, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        
        for(String key : mapA.keySet()) {
            if(mapA.get(key) == 1 && !mapB.containsKey(key)) list.add(key);
        }
        for(String key : mapB.keySet()) {
            if(mapB.get(key) == 1 && !mapA.containsKey(key)) list.add(key);
        }
        
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}