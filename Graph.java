// Assignment 8
// 0445 Timothy James
// Ava Chong
// Due 4/18/18

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import sun.misc.Queue;
import java.util.Queue;

public class Graph {

	private Map<String,List<Edge>> graphData = new HashMap<String,List<Edge>>();
	private boolean isDirected;
	private boolean isWeighted;
	
	public Graph(boolean isDirected, boolean isWeighted) {
	  this.isDirected = isDirected;
	  this.isWeighted = isWeighted;
	}
	
	// this method will add edges to the graph based on a string.
	// this string is in the form "from,to" 
	// each pair of adjacent nodes should be separated by a semicolon.
	public void addEdges(String edgeList) {
	  for (String edgePair : edgeList.split(";")) {
	    String[] edges = edgePair.split(",");
	    if (edges.length == 2) {
	      addEdge(edges[0], edges[1]);
	    }
	  }
	}
	
	// add an edge from one node to another; if this is a weighted graph this will throw an exception
	public void addEdge(String from, String to) {
	  if (isWeighted) {
	    throw new UnsupportedOperationException("Graph is weighted.");
	  }
	  addEdge(from, to, 1);
	}
	
	// add an edge from one node to another; 
	// this method will handle reversing the edge for undirected graphs
	public void addEdge(String from, String to, int weight) {
	  addOneWayConnection(from, to, weight);
		if (!isDirected) {
		  addOneWayConnection(to, from, weight);
		}
	}
	
	private void addOneWayConnection(String origin, String destination, int weight) {
		List<Edge> connections = graphData.get(origin);
		if (connections == null) {
			connections = new LinkedList<Edge>();
			graphData.put(origin, connections);
		}
		connections.add(new Edge(destination, weight));
	}
	
	// determine if you can travel directly from "from" to "to"
	public boolean isAdjacent(String from, String to) {
	  List<Edge> edges = graphData.get(from);
	  if (edges != null) {
	    for (Edge edge : edges) {
	      if (edge.adjacentNode.equals(to)) {
	        return true;
	      }
	    }
	  }
	  return false;
	}
	
	// return the weight between "from" and "to"
	// if nodes are not adjacent, return null
	public Integer getWeight(String from, String to) {
	  List<Edge> edges = graphData.get(from);
	  if (edges != null) {
	    for (Edge edge : edges) {
	      if (edge.adjacentNode.equals(to)) {
	        return new Integer(edge.weight);
	      }
	    }
	  }
	  return null;
	}
	
	// represent the weight and an adjacent node
	private class Edge {
	  private int weight = 1;
	  private String adjacentNode;
	  
	  public Edge(String adjacentNode, int weight) {
	    this.adjacentNode = adjacentNode;
	  }
	}
	
	public static void main(String[] args) {
	  String nodes = "A,B;B,C;C,D;D,E;A,K;K,E;A,F;F,G;G,H;H,I;I,J;J,E";
	  Graph graph = new Graph(false, false);
	  graph.addEdges(nodes);
	  System.out.println(graph.getShortestPath("A", "E")); // should print [A, K, E]
	}
    
    // Assignment 8
	public List<String> getShortestPath(String from, String to) {
        LinkedList<String> nextVertices = new LinkedList<String>(); //acts like a Queue with .poll and .add
        Map<String,String> visitedVertices = new HashMap<String,String>(); //key = vertex, value = how you traveled to that vertix 
        LinkedList<String> shortestPath = new LinkedList<String>();

        //add origin to queue and map
        nextVertices.add(from);
        visitedVertices.put(from, null);

        while (nextVertices.isEmpty() != true){
            String currentVertex = nextVertices.poll();
            if (currentVertex.equals(to)){
                //calculate path using the map
                String current = currentVertex;
                while (current != from){
                    shortestPath.addFirst(current);
                    String nextCurrent = visitedVertices.get(current);
                    current = nextCurrent;
                }
                shortestPath.addFirst(from);

            }
            else{ //find neighbors
								List<Edge> neighbors = graphData.get(currentVertex); 
								for(Edge e: neighbors){
									String neighborVertex = e.adjacentNode;
									if(!visitedVertices.containsKey(neighborVertex)){ //if not visited add to queue and map
											visitedVertices.put(neighborVertex, currentVertex);
											nextVertices.add(neighborVertex);
									}
								}
            	}
        }      
    return shortestPath;

    }
}