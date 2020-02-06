class Solution {
    
    class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;
        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int p) {
            
            while(parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        
        public void union(int i, int j) {
            
            int x = find(i);
            int y = find(j);
            
            if(x == y) return;
            
            if(rank[x] > rank[y]) {
                parent[y] = x;
            } else {
                parent[x] = y;
                if(rank[x] == rank[y]) rank[y]++;
            }
            count--;
            
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] M) {
        
        UnionFind uf = new UnionFind(M.length);
        
        for(int i = 0; i < M.length; i++) {
            for(int j = i + 1; j < M[0].length; j++) {
                if(M[i][j] == 1) uf.union(i, j);
            }
        }
        
        return uf.count;
    }
}