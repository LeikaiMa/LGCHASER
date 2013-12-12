package treeSearch;

import java.util.ArrayList;


public class Node {
	public enum State {
		Unvisited, Visited, Visiting;
	}
	public route.RouteBetweenTwoNodes.State state;
	public boolean visited = false;
	public ArrayList<Node> adjacent = new ArrayList<>();
	public ArrayList<Node> getAdjacent() {
		// TODO Auto-generated method stub
		return adjacent;
	}

}
