package svv;

import svv.GameConstant.Player;

public class Move {
	
	Player p;
	Cell update;
	
	Move(Player _p, Cell c){
		this.p = _p;
		this.update = c;
	}

}
