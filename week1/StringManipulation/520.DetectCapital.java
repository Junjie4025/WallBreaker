class Solution {
    public boolean detectCapitalUse(String word) {
        
        if(word == null || word.length() <= 1) return true;
        
        for(int i = 1; i < word.length(); i++) {
            
            char c = word.charAt(i);
            
            if(Character.isLowerCase(c)) {
                if(i - 1 > 0 && Character.isUpperCase(word.charAt(i - 1))) return false;
            } else {
                if(Character.isLowerCase(word.charAt(0)) || 
                   i - 1 > 0 && Character.isLowerCase(word.charAt(i - 1))) return false;
            }
            
        }
        
        return true;
    }
}