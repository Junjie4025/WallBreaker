class Solution {
    public void solve(char[][] board) {
        
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < board.length; i++) {
            connectToBorder(board, i, 0);
            connectToBorder(board, i, n - 1);
        }
        
        for(int i = 0; i < board[0].length; i++) {
            connectToBorder(board, 0, i);
            connectToBorder(board, m - 1, i);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '*') board[i][j] = 'O';
                
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private void connectToBorder(char[][] board, int i, int j) {
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        
        board[i][j] = '*';
        
        for(int[] dir : dirs) {
            connectToBorder(board, i + dir[0], j + dir[1]);
        }
        
    }
}