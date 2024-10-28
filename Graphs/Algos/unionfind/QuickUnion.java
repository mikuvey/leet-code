class QuickUnion{
    private int[] graph; //Array to store Node values

    //Constructor
    public QuickUnion(int size){ 
        graph = new int[size]; //No. of vertexes in graph

        //Initalize graph array with vertex as their own root
        for(int i=0; i< graph.length; i++){
            graph[i] = i;
        }
    }

    //Find root node of given vertex
    public int find(int vtx){
        //Using Recursion find the root
        //Base Cases - WHen root of a vertex is itsef then the case is satisfied
        if(vtx == graph[vtx]) return vtx;

        return graph[vtx] = find(graph[vtx]); //What the heck is happening here ??
    }

    public void union(int m, int n){
        int rootM = find(m);
        int rootN = find(n);

        if(rootM != rootN) graph[rootN] = rootM; //Set root of N in graph as rootM
    }

    public boolean connected(int m, int n){
        if(find(m) == find(n))
            return true;
        return false;
    }

    public static void main(String[] args){
        long start = System.nanoTime(); //Calculate the runtime
        QuickUnion qf = new QuickUnion( 10);

        System.out.println(qf.find(1));
        qf.union(1,2);
        qf.union(1,7);
        qf.union(2,3);

        qf.union(4,5);
        qf.union(4,6);
        qf.union(0,9);
        qf.union(9,8);
        System.out.println(qf.connected(1,3));

        long duration = System.nanoTime() - start;
        System.out.println(duration);

    }
}