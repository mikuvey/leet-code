class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Creating a adjacency List to build a graph Structure
        //Find Path Algorithm
        
        Map<String, List<String>> adjList = new HashMap<>();
        
        //Add words to map
        adjList.put(beginWord, new ArrayList<String>());
        for(String str: wordList){
            List<String> lst = new ArrayList<>();
            adjList.put(str, lst);
        }
        
        //Base Case
        if(!adjList.containsKey(endWord)){
            return 0;
        }
        
        //Consider for a key, if a given word is only one letter diff then add to the list; else pass
        /*Algo:
        1. Use two for loops where we check for a string match with one less letter
        */
        
        for(String key: adjList.keySet()){
            //Iterate over each word in the list except itself
            for(String str: wordList){
                if(key.equals(str)) continue;
                
                //Compare the letters make sure they are of same length first
                //Then go letter by letter if similarity diff is 1 then add to list
                int diff = 0;
                char[] keyChar = key.toCharArray();
                char[] strChar = str.toCharArray();
                
                if(key.length() == str.length()){
                    for(int i=0; i<keyChar.length; i++){
                        if(diff > 1) break;
                        if(keyChar[i] != strChar[i]) diff += 1;
                    }
                }
                
                if(diff == 1){
                    List<String> keyList = adjList.get(key);
                    keyList.add(str);
                }
            }
        }
        
        // for(String i: adjList.keySet()){
        //     System.out.println(i +": " + adjList.get(i));
        // }
        
        List<String> ret = bfs(adjList, beginWord, endWord);
        
        return ret.size();
    }
    
    public List<String> bfs(Map<String, List<String>> graph, String source, String target){
        List<String> result = new ArrayList<>();
        
        //Temp list
        List<String> sourceList = new ArrayList<>();
        sourceList.add(source);
        
        Queue<List<String>> que = new LinkedList<>();
        que.add(sourceList);
        
        Set<String> visited  = new HashSet<>();
        
        /*BFS Algorithm to Find shortesh Path: 
        Simply remebember we will be adding the entire path (list) into que for each child and later 
        only new lists with childs of last element of old list.
        1. curr_list = que.remove()
        2. Take the last element of the list
        3. Check if it's the target else
        4. If not visited add all childs of the lists by iterations (creating new list for each child)*/
        
        while(!que.isEmpty()){
            List<String> curr = que.remove();
            
            int len_curr = curr.size();
            
            //If target is found
            String lastElement = curr.get(len_curr-1);
            
            if(lastElement.equals(target)){
                result = curr;
                break;
            }
            
            //If visited don't add it's elemets to the que
            if(visited.contains(lastElement)){
                continue;
            }
            else{
                visited.add(lastElement);
            }
            
            //If not
            for(String str: graph.get(lastElement)){
                List<String> queList = new ArrayList<>(curr);
                queList.add(str);
                que.add(queList);
            }
        }
        
        return result;
    }
}
