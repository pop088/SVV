package svv;

public class GameConstant {
	
	static int numOfPlayer = 2;
	static int statePerCell = 3;
	static int rows = 3;
	static int cols = 3;
	static public enum Player { First, Second };
	static public enum cellState { Empty, Cross, Circle };
	static public enum Winner { First, Second, Neither };

}
