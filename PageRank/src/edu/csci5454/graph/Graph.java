package edu.csci5454.graph;

import java.util.LinkedList;

public class Graph {
  private int V; //Vertices
  private LinkedList<Integer> OutgoingAdj[]; // Outgoing adjacency matrix
  private LinkedList<Integer> IncomingAdj[]; // Incoming adjacency matrix
  
public int getV() {
	return V;
}


public void setV(int v) {
	V = v;
}


public LinkedList<Integer>[] getOutgoingAdj() {
	return OutgoingAdj;
}


public void setOutgoingAdj(LinkedList<Integer>[] adj) {
	this.OutgoingAdj = OutgoingAdj;
}


public LinkedList<Integer>[] getIncomingAdj() {
	return IncomingAdj;
}


public void setIncomingAdj(LinkedList<Integer>[] incomingAdj) {
	IncomingAdj = incomingAdj;
}


Graph initializeGraph(int v){
	  V = v +1;
	  OutgoingAdj = new LinkedList[V];
	  IncomingAdj = new LinkedList[V];
	  
	  for(int i=1 ; i <= v; i++){
		  OutgoingAdj[i] = new LinkedList<Integer>();
	  }
	  
	  for(int i=1 ; i <= v; i++){
		  IncomingAdj[i] = new LinkedList<Integer>();
	  }
	  
	  return this;
  }
  
  
   void addEdge(int s, int d){
	   OutgoingAdj[s].add(d);
	   IncomingAdj[d].add(s);
  }
  
  public Graph createGraph(int v){
	  Graph graph =  initializeGraph(v);
	  // For New graph
	 /* graph.addEdge(1, 2);
	  graph.addEdge(1, 3);
	  graph.addEdge(3, 1);
	  graph.addEdge(3, 2);
	  graph.addEdge(3, 5);
	  graph.addEdge(4, 6);
	  graph.addEdge(4, 5);
	  graph.addEdge(5, 6);
	  graph.addEdge(5, 4);
	  graph.addEdge(6, 4);*/
	  
	  
	  //For graph from http://codispatch.blogspot.com/2015/12/java-program-implement-google-page-rank-algorithm.html//
	  graph.addEdge(1, 2);
	  graph.addEdge(2, 5);
	  graph.addEdge(3, 1);
	  graph.addEdge(3, 2);
	  graph.addEdge(3, 5);
	  graph.addEdge(3, 4);
	  graph.addEdge(4, 3);
	  graph.addEdge(4, 5);
	  graph.addEdge(5, 4);
	  
	  
	  return graph;
	  
  }
}
