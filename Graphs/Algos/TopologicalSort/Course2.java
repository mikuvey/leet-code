package graphs.algos.topologicalsort;
package graphs.algos.TopologicalSort;
package graphs.Algos.TopologicalSort;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Create a Adjacency List out of the preReqs
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int r=0; r<prerequisites.length; r++){
            //Create a new List for the key if not present
            if(!map.containsKey(prerequisites[r][1])){
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[r][0]);
                         
                map.put(prerequisites[r][1], list);
            }
            else{
                List<Integer> list = map.get(prerequisites[r][1]);
                list.add(prerequisites[r][0]);
                
                map.put(prerequisites[r][1], list);
            }             
        }
                         
        System.out.println(map);
        //BFS or DFS to find the nodes in order
        // List<List<Integer> result = bfs(map, numCourses);
        
        int[] arr = {0};
        return arr;
    }
    
    public List<List<Integer> bfs(Map<Integer> graph,int numCourses){
        List<List<Integer>> ret = new ArrayList<>();
        
        Queue<Integer, List<Integer>> que = new LinkedList<>();
        List<Integer> lst = new ArrayList<>();
        lst.add(graph);
        
        return ret;
    }
}
