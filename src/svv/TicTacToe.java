package svv;

import java.util.List;

import svv.GameConstant.Winner;

public class TicTacToe extends BoardState {
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Winner getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardState getInitState() {
		// TODO Auto-generated method stub
		return new TicTacToe();
	}

	@Override
	public BoardState initBoardConstant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Move> getPossibleMove() {
		// TODO Auto-generated method stub
		return null;
	}

}
