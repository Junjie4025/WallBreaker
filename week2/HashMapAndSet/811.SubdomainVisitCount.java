class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : cpdomains) {
            
            String[] arr = s.split(" ");
            int count = Integer.parseInt(arr[0]);
            
            map.put(arr[1], map.getOrDefault(arr[1], 0) + count);
            for(int i = 0; i < arr[1].length() - 1; i++) {
                if(arr[1].charAt(i) == '.') {
                    String sub = arr[1].substring(i + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + count);
                }
            }
            
        }
        
        List<String> res = new ArrayList<>();
        for(String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        
        return res;
    }
}