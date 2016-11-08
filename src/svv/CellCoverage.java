package svv;

import java.util.HashSet;
import java.util.Set;

public class CellCoverage {
	int allstate = GameConstant.rows * GameConstant.cols * GameConstant.statePerCell;
	int curVisited = 0;
	
	Set<Cell> visited;
	
	CellCoverage(){
		visited = new HashSet<Cell>();
	}
	
	public void update(BoardState bs){
		for(Coordinate coor : bs.matrix.keySet()){
			if(visited.add(bs.matrix.get(coor))){
				curVisited++;
			}
		}
	}
	
	public float getCoverage(){
		return curVisited / allstate;
	}
	
	
}
