
public class Main {
	public static void main(String []args) {
		//pole a výplň
		int board[][] = new int[20][20];
		int board1[][] = new int[20][20];
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				//board[i][j] = 0;
			}
		}
		int count = 0;
		/*board[2][5] = 1;
		board[2][6] = 1;
		board[2][7] = 1;*/
		board[15][5] = 1;
		board[15][6] = 1;
		board[15][7] = 1;
		board[16][7] = 1;
		board[17][6] = 1;


		
		while(true) {
		//death border
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

		for(int i = 1; i < board.length-1; i++) {
			for(int j = 1; j < board[0].length-1; j++) {
				if(board[i-1][j-1] == 1) {count++;}//0
				if(board[i-1][j] == 1) {count++;} //1
				if(board[i-1][j+1] == 1) {count++;} // 2
				if(board[i][j-1] == 1) {count++;} //3
				if(board[i][j+1] == 1) {count++;} //4
				if(board[i+1][j-1] == 1) {count++;} //5
				if(board[i+1][j] == 1) {count++;} //6
				if(board[i+1][j+1] == 1) {count++;} //7
				
				board1[i][j] = count;
				count = 0;
			}
		}
		for(int i = 0; i < board.length; i++) {
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

		
		//glider
		/*board[5][5] = 1;
		board[5][6] = 1;
		board[5][7] = 1;
		board[6][7] = 1;
		board[7][6] = 1;*/

		
		//draw board
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board1[i][j]);
			}
			System.out.print(' ');
			for(int j = 0; j < board[0].length; j++) {
				
					System.out.print(board[i][j]);
				
			}
			System.out.print('\n');
		}

		//sleep for 1 second
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
