package A3;

import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

public class Graphs {
	  public static void main(String[] args) {
		 
	    }
	/**
	 * Description
	 * @param graph input graph
	 * @param origin starting vertex
	 * @param numberOfEdges
	 * @return Set of vertices within the specified numberOfEdges
	 * Should follow BFS
	 * Referenced following link to understand and implement BFS https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
	 */
	public static Set<String> nearby(Graph graph, String origin, int numberOfEdges) {
		
		Set <String>result = new LinkedHashSet<>();
		
		if (numberOfEdges < 1) {
			return result;
		}
		Queue<String> node = new LinkedList<>(); //Node queue
		Queue<Integer> distanceBtw = new LinkedList<>(); // Distance between each node and origin queue
		
		node.add(origin); // Set first node to origin point
		distanceBtw.add(0); // Set initial distance to 0
		
		Set<String> passed = new LinkedHashSet<>(); // List of nodes program has gone through and passed
        passed.add(origin); // add the origin node to the list of passed nodes
		
		
		while(!node.isEmpty()) {
			String currNode = node.poll();
			int currDist = distanceBtw.poll();
			
			if(currDist <= numberOfEdges) {
				break;
			}
			
			for(String closestVertice : graph.vertices()) { // Iterate over every vertex
				if(passed.contains(currNode) == false){ // Conditional which verifies whether or not current node has been passed by/gone through
					passed.add(closestVertice); // Adds the closest vertex into the passed string list
					node.add(closestVertice); // Adds the closest vertex to the node queue string list
					distanceBtw.add(currDist + 1); // Distance between the current node and its neighboring nodes
					result.add(closestVertice + ", " + (currDist + 1)); //Adds the closest vertex and its distance to the result
				}
			}
		}
		return result;
	}
	

}
