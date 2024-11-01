package graphs.disjoints;

public class QuickFind {
    
    private int[] disjointSet;

    public QuickFind(int size){
        //Build a disjoint set focusing and find operation O(1)
        disjointSet = new int[size];

        //Initially every element is a root of itself
        for(int i=0; i<size; i++){
            disjointSet[i] = i;
        }
    }

    public int find(int x){
        return disjointSet[x];
    }

    public void union(int x, int y){
        //If already connected exist
        rootX = disjointSet[x];
        rootY = disjointSet[y];

        if(rootX != rootY){
            for(int i=0; i<disjointSet.length; i++{
                if(disjointSet[i] == rootY){
                    disjointSet[i] = rootX;
                }
            }
        }
    }

    public boolean connected(int x, int y){
        if(disjointSet[x] == disjointSet[y]) return true;
        return false;
    }
}
