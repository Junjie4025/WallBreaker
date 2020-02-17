class Solution {
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    
    public String longestWord(String[] words) {
        
        Arrays.sort(words, (a, b) -> a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));
        
        
        TrieNode root = new TrieNode();
        
        String res = "";
        for(String word : words) {
            
            TrieNode cur = root;
            int i = 0;
            while(i < word.length()) {
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null || !cur.children[c - 'a'].isWord) {
                    if(i == word.length() - 1) {
                        cur.children[c - 'a'] = new TrieNode();
                        cur.children[c - 'a'].isWord = true;
                    } else {
                        break;
                    }
                } else {
                    cur = cur.children[c - 'a'];
                    if(i == word.length() - 1) cur.isWord = true;
                }
                i++;
            }
            
            if(i == word.length() && word.length() > res.length()) {
                res = word;
            }
            
        }
        
        return res;
    }
}