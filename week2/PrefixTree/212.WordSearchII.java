class Solution {
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
            this.word = null;
        }
    }
    
    private void buildTrie(TrieNode root, String[] words) {
        
        TrieNode cur;
        for(String word : words) {
            cur = root;
            for(char c : word.toCharArray()) {
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
            cur.word = word;
        }
        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        if(board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
        
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, i, j, visited, root, set);
            }
        }
        
        return new ArrayList<>(set);
    }
    
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private void dfs(char[][] board, int i, int j, boolean[][] visited, TrieNode root, Set<String> set) {
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) 
            return;
        
        root = root.children[board[i][j] - 'a'];
        
        if(root == null) return;
        
        if(root.isWord) {
            set.add(root.word);
        }
        
        visited[i][j] = true;
        
        for(int[] dir : dirs) {
            
            dfs(board, i + dir[0], j + dir[1], visited, root, set);
            
        }
        
        visited[i][j] = false;
    }
}