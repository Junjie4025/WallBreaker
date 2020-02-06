class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0' || visited[i][j]) continue;
                dfs(grid, visited, i, j);
                res++;
            }
        }
        
        return res;
    }
    
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        
        if(grid[i][j] == '0' || visited[i][j]) return;
        
        visited[i][j] = true;
        
        for(int[] dir : dirs) {
            dfs(grid, visited, i + dir[0], j + dir[1]);
        }
        
    }
}