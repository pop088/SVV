package svv;

public class Driver {

	static BoardState nextState(BoardState prev, Move _move) throws Exception {
		prev.makeMove(_move);
		return prev;
	}
}
