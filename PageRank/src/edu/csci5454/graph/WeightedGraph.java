package edu.csci5454.graph;

public class WeightedGraph {
    static int vertices = 6;
    public double [][] matrix;
    int[] incominglinks = {3, 7, 4, 4, 9, 10}; 
    int[] outgoinglinks = {8, 0, 8, 7, 8, 2};
    
    public int[] getIncominglinks() {
		return incominglinks;
	}

	
	public int[] getOutgoinglinks() {
		return outgoinglinks;
	}

	public WeightedGraph(){
		matrix = new double[vertices][vertices];
	  	  for(int i = 0; i < vertices; i++){
	  		for(int j = 0; j < vertices; j++){
	  		  matrix[i][j] = 0.0;
	  	    }
	  	  }
    }
	
	public void addEdge(int a, int b, double weight){
	  	  matrix[a][b] = weight;
	}
	
	public void constructGraph(){
		addEdge(0, 1, 1.0);
		addEdge(0, 2, 7.0);
		addEdge(2, 1, 2.0);
		addEdge(2, 0, 3.0);
		addEdge(2, 4, 6.0);
		addEdge(4, 5, 6.0);
		addEdge(4, 3, 2.0);
		addEdge(3, 4, 3.0);
		addEdge(3, 5, 4.0);
		addEdge(5, 3, 2.0);
	}
	
	
      
}


