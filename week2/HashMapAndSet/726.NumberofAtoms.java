class Solution {
    public String countOfAtoms(String formula) {
        
        Map<String, Integer> map = helper(formula);
        StringBuilder sb = new StringBuilder();
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(String key : list) {
            sb.append(key);
            if(map.get(key) > 1) sb.append(map.get(key));
        }
        
        return sb.toString();
    }
    
    private Map<String, Integer> helper(String s) {
        
        Map<String, Integer> map = new HashMap<>();
        
        if(s.isEmpty()) return map;
        
        int i = 0;
        while(i < s.length()) {
            
            if(Character.isUpperCase(s.charAt(i))) {
                int j = i;
                while(i + 1 < s.length() && Character.isLowerCase(s.charAt(i + 1))) i++;
                String atom = s.substring(j, i + 1);
                
                j = i;
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;
                int num = 1;
                if(i > j) num = Integer.parseInt(s.substring(j + 1, i + 1));
                
                map.put(atom, map.getOrDefault(atom, 0) + num);
                i++;
            } else {
                int j = i;
                int count = 1;
                while(i + 1 < s.length() && count > 0) {
                    if(s.charAt(i + 1) == '(') count++;
                    if(s.charAt(i + 1) == ')') count--;
                    i++;
                }
                Map<String, Integer> subMap = helper(s.substring(j + 1, i));
                
                j = i;
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;
                int num = 1;
                if(i > j) num = Integer.parseInt(s.substring(j + 1, i + 1));
                
                for(String key : subMap.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + subMap.get(key) * num);
                }
                
                i++;
            }
            
        }
        return map;
    }
}