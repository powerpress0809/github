package Omok.VictoryLogic;

import java.util.Iterator;
import java.util.Scanner;

public class Omok {
		static boolean turn = true;
		
		// 너무나도 바보여서 일단 x축 y축 나눠서 입력
		static String[] plstone_x = new String[150];
		static int[] plstone_y = new int[150];
		
		static int[] comstone_x = new int[150];
		static int[] comstone_y = new int[150];
		
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
        		String[] stoneDrop = pl.split(" ");
        	
        		
        			if (stoneDrop.length == 2) {
        				int col = convertInputToValue(stoneDrop[0]);
        				int row = Integer.parseInt(stoneDrop[1]);
        				
        				String [][] loc = new String [col][row];
        				
        				
        				turn = false;
        			
        			}else {
        				System.out.println("잘못된 입력입니다. 올바른 형식으로 입력해주세요.");
        			}
        			
        	}else if(turn != true) {
        		System.out.println(); 
        		System.out.print(computer.getName() + " > ");
        		String pl = sc.nextLine();
        		String[] stoneDrop = pl.split(" ");
        			
	        		if (stoneDrop.length == 2) {
	    				int col = convertInputToValue(stoneDrop[0]);
	    				int row = Integer.parseInt(stoneDrop[1]);
        		
	    				
	    				
	    				
	    				
	    				turn = true;
	        		}else {
        				System.out.println("잘못된 입력입니다. 올바른 형식으로 입력해주세요.");
        			}
        	}
    		
    	}
    	
	}

    private static int convertInputToValue(String pl) {
        int value = pl.toLowerCase().charAt(0) - 'a';
        return value;
    }
}