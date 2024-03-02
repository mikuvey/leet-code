package DSA.Graphs;

class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        
        boolean valid = false;
        int numEdges = edges.length;
        
        UnionFind uf = new UnionFind(n); //Double Check length, as it should be number of nodes not number of edges
        
        //To be a Tree and not a graph it should satisfy following cases
        //1.Number of nodes = n+1 edges
        if(n -1 == numEdges){
            valid = true;
        }
        else{
            return false;
        }
        
        //2.Every node should be connected to eachother
        //Using UnionFind
        for(int i=0; i<numEdges; i++){
            uf.union(edges[i][0], edges[i][1]);
        }
        
        if(uf.getCount() == 1){
            valid = true;
        }
        else {
            valid = false;
        }
        
        return valid;
        
    }
}

class UnionFind{
    int[] rank;
    int[] root;
    int count;

    public UnionFind(int size){
        this.rank = new int[size];
        this.root = new int[size];
        this.count = size;

        for(int i=0; i< size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int m, int n){
        int rootM = find(m);
        int rootN = find(n);

        if(rootM != rootN){
            if(rank[rootM] > rank[rootN]) root[rootN] = rootM;
            else if(rank[rootN] > rank[rootN]) root[rootM] = rootN;
            else{
                root[rootN] = rootM;
                rank[rootM] += 1;
            }
            this.count--;
        }
    }

    public int find(int x){
        if(x==root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }

    public int getCount(){
        return this.count;
    }
}