package Omok;

import java.util.Scanner;

public class Omok3 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Player user = new Player("사용자", "O");
		Player computer = new Player("컴퓨터", "X");
		Board board222 = new Board(19);
		board222.print();
		play(board222, user, computer);
	}

	private static void play(Board board, Player user, Player computer) {
		// 전체 게임 구동 여부
		boolean on = true;
		
		// 게임 턴 switch
		int turn = 0;
		
		while (on) {
			board.print();
			
			if(turn % 2 == 0) {
				System.out.print(user.getName() + " > ");
			}else {
				System.out.print(computer.getName() + " > ");
			}
			String pl = sc.nextLine(); // 10 a
			String[] input = pl.split(" "); // input [0] = 10 input [1] = a
			int row = Integer.parseInt(input[0]);
			int col = convertInputToValue(input[1]);
			
			if(turn % 2 == 0) {
				board.map[row][col] = user.stone; // [10][a]
			}else {
				board.map[row][col] = computer.stone; // [10][a]
			}

			// 메소드명();
			if(turn % 2 == 0) {
				on = (victoryLogic(board, user, row, col)); // false
			}else {
				on = (victoryLogic(board, computer, row, col)); // false
			}
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
		return true;
	}
}
