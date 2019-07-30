import java.util.*;

public class Ex10 {
	final int N = 8;

  public static void main(String args[]) {
		Ex10 ex = new Ex10();
	}

  public Ex10() {
    int[][] board = new int[N][N]; // Initial value is 0.

    if (put_queen(board, 0) == false) {
			System.out.print("Solution does not exist");
		} else {
      printSolution(board);
    }
  }

	public void printSolution(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
        String str = board[i][j] == 1 ? "Q" : ".";
        System.out.print(" " + str + " ");
      }
			System.out.println();
		}
	}

	public boolean getStatus(int board[][], int row, int col) {
		int i, j;

		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	public boolean put_queen(int board[][], int col) {
		if (col >= N) return true;

		for (int i = 0; i < N; i++) {
			if (getStatus(board, i, col)) {
				board[i][col] = 1;
				if (put_queen(board, col+1) == true) return true;
				board[i][col] = 0;
			}
		}

		return false;
	}
}
