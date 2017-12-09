package edu.csci5454.pagerank;

import edu.csci5454.graph.Graph;

public class BasicPageRankImpl {
	static double V = 5;
	static double dampingFactor = .85;
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		double pagerank[] = new double[(int)V+1];
		
		graph.createGraph((int)V);
		
		//Initialize page rank of all pages
		for(int i=1; i<= V; i++){
			pagerank[i] = (1/V);
		}
		
		for(int steps =0; steps < 10; steps++)
			pagerank = calculatePagerank(graph, pagerank);
		for(int i=1; i<= V; i++)
			System.out.println(pagerank[i]);
		
		
	}

	private static double[] calculatePagerank(Graph graph, double[] pagerank) {
		double totalIncomingPagerank = 0;
		double  newPageRank[] = new double[pagerank.length];
		int incomingnode = 0;
		for(int page=1; page <= V ; page++){
			for(int j=0; j < graph.getIncomingAdj()[page].size(); j++){
				 incomingnode = (int) graph.getIncomingAdj()[page].get(j);
				 totalIncomingPagerank  +=  (pagerank[incomingnode])/(double)(graph.getOutgoingAdj()[incomingnode].size());			
			}
			newPageRank[page] = ((1-dampingFactor) + dampingFactor*totalIncomingPagerank);
			totalIncomingPagerank = 0;
		}
		return newPageRank;
	}
	
}
