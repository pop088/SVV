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
				
				bw.write(curMove.toString() + ", " + cur.toString() + "\n");
			}
			bw.write("\n");
		}
		bw.close();
	}
	
	static float runTests(GameSocket gs, BoardState bs) throws Exception{
		
		int passCases = 0;
		int totalCases = 0;
		
		
		CellCoverage cc = new CellCoverage(bs.getInitState());
		BoardState cur;
		
		
		while(cc.getCoverage() < 1.0){
			cur = bs.getInitState();
			gs.startNewGame();
			
			while(cur.getWinner() != Winner.Neither){
				
				List<Move> possibleMoves = cur.getPossibleMove();
				Random r = new Random();
				int movePicked = r.nextInt(possibleMoves.size());
				Move curMove = possibleMoves.get(movePicked);
				
				cur = nextState(cur, curMove);
				gs.makeMove(curMove);
				totalCases += 1;
				if(cur.cmp(gs.getBoard())){
					passCases += 1;
				}
				
				cc.update(cur);
			}
			
			totalCases += 1;
			if(cur.getWinner() == gs.getWinner()){
				passCases += 1;
			}
			
		}
		
		return passCases / totalCases;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		//String path = "./";
		//genTests(path, new TicTacToeTester().getInitState());
		float testScore = runTests(new TicTacToeSocket(), new TicTacToeTester());
		System.out.println(testScore);
	}
	
}
