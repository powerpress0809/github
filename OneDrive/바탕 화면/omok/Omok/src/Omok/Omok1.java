package Omok;

import java.util.Scanner;

public class Omok1 {
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
		boolean turn = true;
		
		while (on) {

			board.print();

			if (turn == true) {
				System.out.println();
				System.out.println(user.getName() + " > ");
				String pl = sc.nextLine(); // 10 a
				String[] input = pl.split(" "); // input [0] = 10 input [1] = a
				int row = Integer.parseInt(input[0]);
				int col = convertInputToValue(input[1]);
				board.map[row][col] = user.stone; // [10][a]

				// 메소드명();
				on = (victoryLogic(board, user, computer, row, col)); // false
				
				turn = false;

			} else if (turn != true) {
				System.out.println();
				System.out.println(computer.getName() + " > ");
				String pl = sc.nextLine(); // 10 a
				String[] input = pl.split(" "); // input [0] = 10 input [1] = a
				int row = Integer.parseInt(input[0]);
				int col = convertInputToValue(input[1]);
				board.map[row][col] = computer.stone; // [10][a]

//				// 메소드명();
				victoryLogic(board, user, computer, row, col);
				turn = true;

			}

		}

	}

	// 아스키 코드
	private static int convertInputToValue(String pl) {
		int value = pl.toLowerCase().charAt(0) - 'a';

		return value;
	}

	static boolean victoryLogic(Board board, Player user, Player computer, int row, int col) {
		// 가로 [row]는 고정에, [col]은 0부터 18중 5개 연속된 숫자..
		// 10 = row , a = col
		// i는 0부터 19까지 (0 ~ 18)

		int counter = 0;

		for (int i = 0; i < 19; i++) {
			if (board.map[row][i] == user.stone) {
				counter += 1;

				if (counter == 5) {
					System.out.println("플레이어의 승리!!");
					return false;
				}

			} else if (board.map[row][i] != user.stone) {
				counter = 0;
			}
		}
		return true;
	}
}
