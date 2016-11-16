package svv;

import svv.GameConstant.Winner;

public interface GameSocket {
	public abstract BoardState getBoard();
	
	public abstract void startNewGame();
	
	public abstract void makeMove(Move m);
	
	public abstract Winner getWinner();
}
