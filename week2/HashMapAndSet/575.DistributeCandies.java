class Solution {
    public int distributeCandies(int[] candies) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int candy : candies) {
            set.add(candy);
        }
        
        return candies.length / 2 >= set.size() ? set.size() : candies.length / 2;
    }
}