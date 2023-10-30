package Omok;

import java.util.Scanner;

public class OmokDiagonal {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Player user = new Player("사용자", "O");
		Player computer = new Player("컴퓨터", "X");
		Board board222 = new Board(19);
		play(board222, user, computer);
	}

	private static void play(Board board, Player user, Player computer) {
		// 전체 게임 구동 여부
		boolean on = true;
		
		// 게임 턴 switch
		int turn = 0;
		Player[] player = new Player[2];
		player[0] = user;
		player[1] = computer;
		
		while (on) {
			board.print();
			System.out.println();
			System.out.print(player[turn % 2].getName() + " > ");

			String pl = sc.nextLine(); // 10 a
			String[] input = pl.split(" "); // input [0] = 10 input [1] = a
			int row = Integer.parseInt(input[0]);
			int col = convertInputToValue(input[1]);
			board.map[row][col] = player[turn % 2].stone; // [10][a]

			on = (victoryLogic(board, player[turn % 2], row, col)); // false
			on = (diagonalLogic_LeftUptoRightDown(board, player[turn % 2], row, col)); // false
			on = (diagonalLogic_LeftDowntoRightUp(board, player[turn % 2], row, col)); // sfalse
			turn++;
		}

	}

	// 아스키 코드
	private static int convertInputToValue(String pl) {
		int value = pl.toLowerCase().charAt(0) - 'a';

		return value;
	}

	static boolean victoryLogic(Board board, Player player, int row, int col) {
		// 가로 [row]는 고정에, [col]은 0부터 18중 5개 연속된 숫자..
		// 10 = row , a = col
		// i는 0부터 19까지 (0 ~ 18)

		int counter = 0;
		
		
		for (int i = 0; i < 19; i++) {
			if (board.map[row][i] == player.stone) {
				counter += 1;

				if (counter == 5) {
					System.out.println("플레이어의 승리!!");
					return false;
				}

			} else if (board.map[row][i] != player.stone) {
				counter = 0;
			}
		}
		
		
		
		for (int i = 0; i < 19; i++) {
			if (board.map[i][col] == player.stone) {
				counter += 1;

				if (counter == 5) {
					System.out.println("플레이어의 승리!!");
					return false;
				}

			} else if (board.map[i][col] != player.stone) {
				counter = 0;
			}
		}
		
		return true;
	}
	
	static boolean diagonalLogic_LeftUptoRightDown(Board board, Player player, int row, int col) {
		// 가로 [row]는 고정에, [col]은 0부터 18중 5개 연속된 숫자..
		// 10 = row , a = col
		// i는 0부터 19까지 (0 ~ 18)

		int counter = 0;
		
		// 대각선 방향 (왼쪽 위에서 오른쪽 아래로)
		
		int startRow = Math.max(0, row - col);
		int startCol = Math.max(0, col - row);
		int endRow = Math.min(18, row + (18 - col));
		int endCol = Math.min(18, col + (18 - row));
		for (int i = 0; i <= endRow - startRow; i++) {
		    if (board.map[startRow + i][startCol + i] == player.stone) {
		        counter += 1;
		        if (counter == 5) {
		            System.out.println("플레이어의 승리!!");
		            return false;
		        }
		    } else {
		        counter = 0;
		    }
		}

		return true;
	}
	
	static boolean diagonalLogic_LeftDowntoRightUp(Board board, Player player, int row, int col) {
		// 가로 [row]는 고정에, [col]은 0부터 18중 5개 연속된 숫자..
		// 10 = row , a = col
		// i는 0부터 19까지 (0 ~ 18)

		int counter = 0;
		
		// 대각선 방향 (왼쪽 아래에서 오른쪽 위로)
		
		int startRow = Math.max(18, row - col);
		int startCol = Math.min(0, col - row);
		int endRow = Math.min(0, row + (18 - col));
		int endCol = Math.max(18, col + (18 - row));
		
		// 
		for (int i = 0; i <= endRow - startRow; i++) {
		    if (board.map[startRow - i][startCol + i] == player.stone) {
		        counter += 1;
		        if (counter == 5) {
		            System.out.println("플레이어의 승리!!");
		            return false;
		        }
		    } else {
		        counter = 0;
		    }
		}

		return true;
	}

	
	

}
