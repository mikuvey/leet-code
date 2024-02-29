package DSA.Graphs.Algorithms;

class QuickFind{
    
    int[] graph;
    // A Root is the one who's parent is itself
    //Define Constructor where we initalize the array for storing the edges of the Graph
    public QuickFind(int size){
        //Declare an array of length size
        this.graph = new int[size];

        //Initalize the graph array with root nodes (i.e. itself before union)
        for(int i=0; i<size; i++){
            graph[i] = i;
        }
    }

    //Define Find method to return the root node of the vertex(Should be of O(1))
    public int find(int vertex){
        int root = this.graph[vertex];
        return root;
    }

    //Define a method to Union two vertexes; and based on the declared root change all the roots of it's associated vertexes.
    public void union(int m, int n){
        //If m and n have the same root; do nothing
        //Else change n root and it's associates to m 
        if(find(m) != find(n)){
            int rootM = this.graph[m];
            int rootN = this.graph[n];
            
            //Iterate and replace all root of N to M
            for(int i=0; i<graph.length; i++){
                if(graph[i] == rootN) graph[i] = rootM;
            }
        }
    }

    //Check if two nodes are connected or not
    public boolean connected(int m, int n){
        if(this.graph[m] == this.graph[n]) return true;
        return false;
    }

    public static void main(String[] args){
        QuickFind qf = new QuickFind( 10);

        System.out.println(qf.find(1));
        qf.union(1,2);
        qf.union(1,7);
        qf.union(2,3);

        qf.union(4,5);
        qf.union(4,6);
        qf.union(0,9);
        qf.union(9,8);
        System.out.println(qf.connected(1,8));

    }
}