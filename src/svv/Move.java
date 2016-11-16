package svv;

import svv.GameConstant.Player;

public class Move {
	
	Player nextPlayer;
	Cell update;
	
	
	Move(Player _p, Cell c){
		this.nextPlayer = _p;
		this.update = c;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(update.row + " ");
		sb.append(update.col + " ");
		sb.append(update.getState().toString());
		return sb.toString();
	}

}
