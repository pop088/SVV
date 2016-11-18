package svv;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class CellCoverage {
	int allstate = 0;
	int curVisited = 0;
	
	Set<Cell> visited;
	
	CellCoverage(BoardState bs){
		visited = new HashSet<Cell>();
		allstate = bs.rows * bs.cols * bs.statePerCell;
	}
	
	public void update(BoardState bs){
		for(Point coor : bs.matrix.keySet()){
			if(visited.add(bs.matrix.get(coor))){
				curVisited++;
			}
		}
	}
	
	public float getCoverage(){
		return curVisited / allstate;
	}
	
	
}
