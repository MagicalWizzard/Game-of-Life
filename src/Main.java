
public class Main {
	public static void main(String []args) {
		//pole a výplň
		int board[][] = new int[20][20]; // board of the pixels
		int board1[][] = new int[20][20]; // second board, but for the numbers that the pixels create so that the algorythm can apply GOF rules
		
		/*for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				//board[i][j] = 0;
			}
		}*/ 
		int count = 0; // this is literally the key number that is on the indexes of the second board and rules work thanks to this number
		/*board[2][5] = 1;
		board[2][6] = 1;
		board[2][7] = 1;*/
		board[15][5] = 1; // add pixels to the board a.k.a. the glider
		board[15][6] = 1;
		board[15][7] = 1;
		board[16][7] = 1;
		board[17][6] = 1;


		
		while(true) { // game loop
		//death border // this didn't work well so i just commented it out
		/*for(int i = 0; i < board.length; i++) {
		board[0][i] = 0;
		board[board.length-1][i] = 0;
		}
		for(int i = 0; i < board.length; i++) {
		board[i][0] = 0;
		board[i][board.length-1] = 0;
		}*/
		//'clean board'
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(' ');
			}
			System.out.print('\n');
		}

		for(int i = 1; i < board.length-1; i++) { // this adds +1 to the count number when alive pixels are near the cursor
			for(int j = 1; j < board[0].length-1; j++) { // the cursors positions are i and j, i for y, j for x, and they start from the left upper side of the corner
				if(board[i-1][j-1] == 1) {count++;}//0
				if(board[i-1][j] == 1) {count++;} //1
				if(board[i-1][j+1] == 1) {count++;} // 2
				if(board[i][j-1] == 1) {count++;} //3
				if(board[i][j+1] == 1) {count++;} //4
				if(board[i+1][j-1] == 1) {count++;} //5
				if(board[i+1][j] == 1) {count++;} //6
				if(board[i+1][j+1] == 1) {count++;} //7
				
				board1[i][j] = count; // set the count number to the corresponding board1 positions that the cursor is at
				count = 0;
			}
		}
		for(int i = 0; i < board.length; i++) { // game rules that work with the count number/variable of the second board indexes/pixels
			for(int j = 0; j < board[0].length; j++) {
				//survives
				if((board[i][j] == 1 && board1[i][j] == 2) || (board[i][j] == 1 && board1[i][j] == 3)) {
					board[i][j] = 1;
				}
				//become alive
				if(board[i][j] == 0 && board1[i][j] == 3) {
					board[i][j] = 1;
				}
				//die off
				if((board[i][j] == 1 && board1[i][j] == 1) || (board[i][j] == 1 && board1[i][j] == 0)) {
					board[i][j] = 0;
				}
				if(board[i][j] == 1 && board1[i][j] > 3) {
					board[i][j] = 0;
				}
				
			}
		}
			
		//draw board
		for(int i = 0; i < board.length; i++) { // this is like this so that the arrays can be drawn next to each other
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board1[i][j]);
			}
			System.out.print(' ');
			for(int j = 0; j < board[0].length; j++) {
				
					System.out.print(board[i][j]);
				
			}
			System.out.print('\n');
		}

		// sleep for 100 miliseconds
		// try catch is needed to catch possible exceptions that the class Thread creates when used -- java thing
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
