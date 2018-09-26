package clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { 
    	label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
    }
};
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> old_new_map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return copyGraph(node, old_new_map);
    }
    
    private UndirectedGraphNode copyGraph(UndirectedGraphNode old, Map<UndirectedGraphNode, UndirectedGraphNode> old_new_map){
    	if(old==null) return null;
    	if(old_new_map.containsKey(old)) return old_new_map.get(old);
    	UndirectedGraphNode newNode = new UndirectedGraphNode(old.label);
    	old_new_map.put(old, newNode);
    	
    	for(UndirectedGraphNode neighbor: old.neighbors){
    		newNode.neighbors.add(copyGraph(neighbor, old_new_map));
    	}
    	return newNode;
    }
}
