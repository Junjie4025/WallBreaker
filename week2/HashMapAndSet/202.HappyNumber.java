class Solution {
    public boolean isHappy(int n) {
        
        if(n <= 0) return false;
        
        Set<Integer> set = new HashSet<>();
        
        while(set.add(n)) {
            
            int temp = 0;
            while(n != 0) {
                int dig = n % 10;
                temp += dig * dig;
                n = n / 10;
            }
            
            n = temp;
            
            if(n == 1) return true;
        }
        
        return false;
    }
}