package svv;

public class Coordinate {
	int row;
	int col;
	
	Coordinate(int _row, int _col){
		this.row = _row;
		this.col = _col;
	}
	
	int getRow(){
		return row;
	}
	
	int getCol(){
		return col;
	}
	
	public static Coordinate of(int _row, int _col){
		return new Coordinate(_row, _col);
	}
}
