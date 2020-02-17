class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++) {
            
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            
            for(int j = 0; j < 9; j++) {
                
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                
                int rowIdx = (i / 3) * 3;
                int colIdx = (i % 3) * 3;
                
                if(board[rowIdx + j / 3][colIdx + j % 3] != '.' && !cube.add(board[rowIdx + j / 3][colIdx + j % 3]))
                    return false;
                
            }
            
        }
        return true;
    }
}