package svv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import svv.GameConstant.Player;
import svv.GameConstant.Winner;
import svv.GameConstant.cellState;

public abstract class BoardState {
	
	int rows;
	int cols;
	
	int numOfPlayer;
	int statePerCell;
	
	public Player turn = Player.First;
	public Winner w = Winner.Neither;
	public HashMap<Coordinate, Cell> matrix = genEmptyBoard();
	
	public abstract boolean isValid();
	
	public abstract Winner getWinner();
	
	public abstract BoardState initBoardConstant();
	
	public abstract BoardState getInitState();
	
	public abstract List<Move> getPossibleMove();
	
	BoardState() {	initBoardConstant(); }
	
	BoardState(Player p, HashMap<Coordinate, Cell> _matrix){
		initBoardConstant();
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
		this.turn = move.nextPlayer;
		matrix.put(Coordinate.of(move.update.row, move.update.col), move.update);
		this.w = getWinner();
	}
	
	public HashMap<Coordinate, Cell> genEmptyBoard(){
		HashMap<Coordinate, Cell> res = new HashMap<Coordinate, Cell>();
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				res.put(Coordinate.of(i, j), new Cell(i, j, cellState.Empty));
			}
		}
		return res;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				sb.append(matrix.get(Coordinate.of(i, j)).cs.toString() + ",");
			}
		}
		
		return sb.toString();
	}
}
