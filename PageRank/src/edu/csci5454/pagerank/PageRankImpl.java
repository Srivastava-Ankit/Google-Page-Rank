package edu.csci5454.pagerank;

import edu.csci5454.graph.Graph;
import edu.csci5454.graph.WeightedGraph;

public class PageRankImpl {
	final static int pages = 6;
	static double dampingFactor = .85;
	static double[][] weightMatrixs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		WeightedGraph weightedgraph = new WeightedGraph();
		weightedgraph.constructGraph();
		weightMatrixs = weightedgraph.matrix;
		double[] pageRank = new double[pages];
		
		for(int i = 0; i < pages; i++){
			pageRank[i] = (double)1/pages;
		}
		
		for(int steps =0; steps < 2; steps++)
			pageRank = calculatePagerank(weightedgraph, pageRank);
		for(int i=0; i<pages; i++)
			System.out.println("Page Rank for Web page " + i + " -> " + pageRank[i]);
		
	}
	
	private static double[] calculatePagerank(WeightedGraph graph, double[] pagerank) {
		double totalIncomingPagerank = 0.0;
		double  newPageRank[] = new double[pagerank.length];
		double incomingnodecontribution = 0;
		for(int page=0; page < pages ; page++){
			for(int j=0; j < graph.getIncominglinks().length; j++){
				if(graph.getOutgoinglinks()[j] != 0)
				   incomingnodecontribution += (double)weightMatrixs[j][page]/graph.getOutgoinglinks()[j];	 			
				
			}
			
			totalIncomingPagerank =  (double)(pagerank[page])+(double)(incomingnodecontribution);
			newPageRank[page] = (double)((1-dampingFactor) + dampingFactor*totalIncomingPagerank);
			incomingnodecontribution = 0;
			totalIncomingPagerank =0;
		}
		return newPageRank;
	}

}
