package graphs.disjoints;

public class QuickFind {
    
    private int[] disjointSet;

    public QuickUnion(int size){
        //Build a disjoint set focusing and find operation O(1)
        disjointSet = new int[size];

        //Initially every element is a root of itself
        for(int i=0; i<size; i++){
            disjointSet[i] = i;
        }
    }

    public int find(int x){
        //Will try to find the root from current element (We know if it's root if it's root of itself)
        while(x != disjointSet[x]){
            x = disjointSet[x];
        }
        return x;
    }

    public void union(int x, int y){
        //If already connected exist
        rootX = find[x];
        rootY = find[y];

        //Change root of y to root of x
        if(rootX != rootY)
            disjointSet[rootY] = rootX;
    }

    public boolean connected(int x, int y){
        if(disjointSet[x] == disjointSet[y]) return true;
        return false;
    }
}
