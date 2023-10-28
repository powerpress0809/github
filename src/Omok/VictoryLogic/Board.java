package Omok.VictoryLogic;

public class Board {
	int size;
    static String[][] map;
    
    Board(int size) { // 19 * 19
        this.size = size;
        map = new String[size][size];
        
        for (int row = 0; row < size; row++) { // 렬
          for (int col = 0; col < size; col++) { // 행
        	  	//   0    0~1
            	map[row][col] =  ".";
          	  }
            }
        }
    
    public void print() {
    	
    	// 세로열 19
        for (int row = 0; row < size; row++) {
        	// 가로열 19
            for (int col = 0; col < size; col++) {
            	
            	//컬럼이 0일때 숫자 붙이기 
            	if (col == 0) {
            		
            		if (row < 10) {
            			System.out.print(" " + row);	
            		}else if(row >= 10) {
            			System.out.print(row);	
            		}
            		
            	}
            	System.out.print(" " + map[row][col]);
               
            }
     
            System.out.println();
        }
        	System.out.print("   A B C D E F G H I J K L M N O P Q R S");
    }
    
}
