package svv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Random;

import svv.GameConstant.Winner;

public class Driver {

	static BoardState nextState(BoardState prev, Move _move) throws Exception {
		prev.makeMove(_move);
		return prev;
	}
	
	static void genTests(String path, BoardState init) throws Exception{
		
		CellCoverage cc = new CellCoverage(init);
		File f = new File(path);
		FileWriter fw = new FileWriter(f.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		BoardState cur;
		while(cc.getCoverage() < 1.0){
			cur = init;
			while(cur.getWinner() != Winner.Neither){
				
				List<Move> possibleMoves = cur.getPossibleMove();
				Random r = new Random();
				int movePicked = r.nextInt(possibleMoves.size());
				Move curMove = possibleMoves.get(movePicked);
				cur = nextState(cur, curMove);
				cc.update(cur);
				
				bw.write(curMove.toString() + " " + cur.toString() + "\n");
			}
			bw.write("\n");
		}
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		
		String path = "./";
		genTests(path, new TicTacToe().getInitState());
	}
	
}
