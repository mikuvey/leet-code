
class NumberProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
            
        UnionFind uf = new UnionFind(n);
        
        //Iterate over cities array and updated connected in the root array
        for(int i=0; i< n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    //city i is connected city j
                    //update root of city j with root of city i
                    //if already updated i.e. both roots are same ignore
                    uf.union(i, j);
                }
            }
        }
        
        return uf.getProvince();   
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

    public int getProvince(){
        return this.count;
    }
}
