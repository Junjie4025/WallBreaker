class Solution {
    public String reverseVowels(String s) {
        
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        char[] arr = s.toCharArray();
        
        int lo = 0, hi = arr.length - 1;
        while(lo < hi) {
            
            while(lo < hi && !set.contains(arr[lo])) lo++;
            
            while(lo < hi && !set.contains(arr[hi])) hi--;
            
            if(lo < hi) {
                char temp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = temp;
                lo++;
                hi--;
            }
            
        }
        
        return new String(arr);
    }
}