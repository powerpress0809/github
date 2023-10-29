package Omok;

import java.util.Scanner;

public class Omok5 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Player user = new Player("�����", "O");
		Player computer = new Player("��ǻ��", "X");
		Board board222 = new Board(19);
		play(board222, user, computer);
	}

	private static void play(Board board, Player user, Player computer) {
		// ��ü ���� ���� ����
		boolean on = true;
		
		// ���� �� switch
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
			turn++;
		}

	}

	// �ƽ�Ű �ڵ�
	private static int convertInputToValue(String pl) {
		int value = pl.toLowerCase().charAt(0) - 'a';

		return value;
	}

	static boolean victoryLogic(Board board, Player player, int row, int col) {
		// ���� [row]�� ������, [col]�� 0���� 18�� 5�� ���ӵ� ����..
		// 10 = row , a = col
		// i�� 0���� 19���� (0 ~ 18)

		int counter = 0;
		
		// ���� , ����
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
//				System.out.println("row: " + row + ", col: " + col);
				
				if (board.map[i][j] == player.stone) {
					counter += 1;

					if (counter == 5) {
						System.out.println(player.getName() + " �� �¸�!! ");
						return false;
					}

				} else if (board.map[i][j] != player.stone) {
					counter = 0;
				}
			}
		}
		
		return true;
	}
}
