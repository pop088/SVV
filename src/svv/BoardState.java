package svv;

import java.awt.Point;
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
	public HashMap<Point, Cell> matrix = genEmptyBoard();
	
	public abstract boolean isValid();
	
	public abstract Winner getWinner();
	
	public abstract BoardState initBoardConstant();
	
	public abstract BoardState getInitState();
	
	public abstract List<Move> getPossibleMove();
	
	BoardState() {	initBoardConstant(); }
	
	BoardState(Player p, HashMap<Point, Cell> _matrix){
		initBoardConstant();
		this.matrix = _matrix;
		this.turn = p;
	}
	
	public boolean cmp(BoardState otherBoard){
		for(Point cur:matrix.keySet()){
			if(!matrix.get(cur).cmp(otherBoard.matrix.get(cur))){
				return false;
			}
		}
		return true;
	}
	
	public List<Cell> getEmptyCells(){
		List<Cell> res = new ArrayList<Cell>();
		
		for(Point Coor: matrix.keySet()){
			Cell cur = matrix.get(Coor);
			if(cur.getState() == cellState.Empty){
				res.add(cur);
			}
		}
		return res;
	}
	
	public void makeMove(Move move) throws Exception{
		this.turn = move.nextPlayer;
		matrix.put(new Point(move.update.row, move.update.col), move.update);
		this.w = getWinner();
	}
	
	public HashMap<Point, Cell> genEmptyBoard(){
		HashMap<Point, Cell> res = new HashMap<Point, Cell>();
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				res.put(new Point(i, j), new Cell(i, j, cellState.Empty));
			}
		}
		return res;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				sb.append(matrix.get(new Point(i, j)).cs.toString() + ",");
			}
		}
		
		return sb.toString();
	}
}
