package Omok;

import java.util.Scanner;

public class Omok {
		static boolean turn = true;
    	static Scanner sc = new Scanner(System.in);
	
    	public static void main(String[] args) {
		
		Player user = new Player("사용자", "O");
        Player computer = new Player("컴퓨터", "X");
        Board board = new Board(19);
        play(board, user, computer);
    }
	
    private static void play(Board board, Player user, Player computer) {
      
    	while (true) {
    		
    		board.print();
        	
        	if (turn) {
        		System.out.println(); 
        		System.out.print(user.getName() + " > ");
        		String pl = sc.nextLine();
        		System.out.println(pl);
        	
        		
        		turn = false;
       

        	}else if(turn != true) {
        		System.out.println(); 
        		System.out.print(computer.getName() + " > ");
        		String com = sc.nextLine();
        		
        		System.out.println(com);
        		
        		turn = true;
        		
        	}
    		
    	}
    	
	}



}