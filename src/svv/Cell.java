package svv;

import svv.GameConstant.cellState;

public class Cell {
	cellState cs;
	public int row;
	public int col;
	
	Cell(int _row, int _col, cellState _cs){
		this.row = _row;
		this.col = _col;
		this.cs = _cs;
	}
	
	public boolean cmp(Cell otherCell){
		return this.row == otherCell.row && this.col == otherCell.col && this.cs == otherCell.cs;
	}
	
	
	public void setState(cellState _cs){
		this.cs = _cs;
	}
	
	public cellState getState(){
		return this.cs;
	}
}
