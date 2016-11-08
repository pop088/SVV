package svv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import svv.GameConstant.Player;
import svv.GameConstant.Winner;
import svv.GameConstant.cellState;

public abstract class BoardState {
	int rows = GameConstant.rows;
	int cols = GameConstant.cols;
	
	public Player turn;
	public Winner w;
	public HashMap<Coordinate, Cell> matrix;
	
	public abstract boolean isValid();
	
	abstract Winner getWinner();
	
	BoardState(Player p, HashMap<Coordinate, Cell> _matrix){
		this.matrix = _matrix;
		this.turn = p;
	}
	
	public boolean cmp(BoardState otherBoard){

		for(Coordinate cur:matrix.keySet()){
			if(!matrix.get(cur).cmp(otherBoard.matrix.get(cur))){
				return false;
			}
		}
		
		return true;
	}
	
	public List<Cell> getEmptyCells(){
		List<Cell> res = new ArrayList<Cell>();
		
		for(Coordinate Coor: matrix.keySet()){
			Cell cur = matrix.get(Coor);
			if(cur.getState() == cellState.Empty){
				res.add(cur);
			}
		}
		return res;
	}
	
	public void makeMove(Move move) throws Exception{
		if(move.p != this.turn){
			throw new Exception("Wrong player to make a move");
		}
		
		matrix.put(Coordinate.of(move.update.row, move.update.col), move.update);
		getWinner();
	}
}
