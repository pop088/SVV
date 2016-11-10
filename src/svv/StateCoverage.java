//package svv;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class StateCoverage {
//	long allstate = (long) (Math.pow(BoardState.statePerCell, BoardState.rows * BoardState.cols) / 4);
//	int curVisited = 0; 
//	
//	Set<BoardState> visited;
//	
//	StateCoverage(){
//		visited = new HashSet<BoardState>();
//	}
//	
//	public void update(BoardState bs){
//		if(visited.add(bs)){
//			curVisited++;
//		}
//	}
//	
//	public float getCoverage(){
//		return curVisited / allstate;
//	}
//}
